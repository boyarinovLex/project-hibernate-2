package com.javarush.boyarinov;

import com.javarush.boyarinov.config.AppContainer;
import com.javarush.boyarinov.config.SessionCreator;
import com.javarush.boyarinov.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Runner {

    private final AppContainer appContainer = new AppContainer();
    private final SessionCreator sessionCreator = appContainer.sessionCreator;

    public static void main(String[] args) {
        Runner runner = new Runner();
        Customer customer = runner.createCustomer();
        runner.returnRentalFilm();
        runner.getRentalFilmFor(customer);
        runner.newFilmHasBeenMade();
        runner.sessionCreator.close();
    }

    public Customer createCustomer() {
        try (Session session = sessionCreator.getSession()) {
            Transaction tx = session.beginTransaction();
            try {
                Address address = new Address();
                City city = appContainer.cityDAO.getByName("Guadalajara");
                address.setCity(city);
                address.setAddress("C. José María Vigil 977");
                address.setDistrict("Jalisco");
                address.setPostalCode("44200");
                address.setPhone("9853412587");
                appContainer.addressDAO.create(address);

                Store store = appContainer.storeDAO
                        .getItems(0, 10)
                        .stream()
                        .findAny()
                        .orElse(null);

                Customer customer = new Customer();
                customer.setFirstName("Sergio");
                customer.setLastName("Perez");
                customer.setAddress(address);
                customer.setEmail("sergioperez@f1.com");
                customer.setStore(store);
                customer.setIsActive(true);
                appContainer.customerDAO.create(customer);
                System.out.printf("Добавлен новый клиент: %s\nПроживающий по адресу: %s\n\n", customer, address);
                tx.commit();
                return customer;
            } catch (Exception e) {
                tx.rollback();
                throw new RuntimeException(e);
            }
        }
    }

    public void returnRentalFilm() {
        try (Session session = sessionCreator.getSession()) {
            Transaction tx = session.beginTransaction();
            try {
                Rental unreturnedFilm = appContainer.rentalDAO.getUnreturnedFilm();
                unreturnedFilm.setReturnDate(LocalDateTime.now());
                Film film = unreturnedFilm.getInventory().getFilm();
                System.out.printf("Покупатель пошел и вернул ранее арендованный фильм: %s\n\n", film.getTitle());
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw new RuntimeException(e);
            }
        }
    }

    public void getRentalFilmFor(Customer customer) {
        try (Session session = sessionCreator.getSession()) {
            Transaction tx = session.beginTransaction();
            try {
                Store store = appContainer.storeDAO
                        .getItems(0, 10)
                        .stream()
                        .findAny()
                        .orElse(null);
                Staff staff = Objects.requireNonNull(store).getStaff();

                Inventory inventory = appContainer.inventoryDAO.getAnyAvailableFilmForRent(store.getId());
                if (Objects.isNull(inventory)) {
                    System.out.println("Нет свободных в прокат фильмов");
                    return;
                }

                Rental rental = new Rental();
                rental.setRentalDate(LocalDateTime.now());
                rental.setCustomer(customer);
                rental.setStaff(staff);
                rental.setInventory(inventory);
                appContainer.rentalDAO.create(rental);

                Payment payment = new Payment();
                payment.setCustomer(customer);
                payment.setRental(rental);
                payment.setStaff(staff);
                payment.setAmount(BigDecimal.valueOf(13.99));
                appContainer.paymentDAO.create(payment);

                System.out.printf("Покупатель, %s %s, сходил в магазин %s и арендовал %s там инвентарь %s\nПри этом он сдела оплату %s у продовца %s\n\n",
                        customer.getFirstName(),
                        customer.getLastName(),
                        store,
                        rental,
                        inventory,
                        payment,
                        staff);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw new RuntimeException(e);
            }
        }
    }

    public void newFilmHasBeenMade() {
        try (Session session = sessionCreator.getSession()) {
            Transaction tx = session.beginTransaction();
            try {
                Film driveToSurvive = createNewFilm();

                Store store = appContainer.storeDAO.getItems(0, 10)
                        .stream()
                        .findAny()
                        .orElse(null);
                Inventory inventory = new Inventory();
                inventory.setStore(store);
                inventory.setFilm(driveToSurvive);
                appContainer.inventoryDAO.create(inventory);

                System.out.printf("Сняли новый фильм %s, и он доступен для аренды %s\n\n", driveToSurvive, inventory);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw new RuntimeException(e);
            }
        }
    }

    private Film createNewFilm() {
        Set<Actor> actors = createNewActors();
        Language english = appContainer.languageDAO.getByName("English");
        Set<Category> categories = appContainer.categoryDAO.getByNames(List.of("Documentary", "Sports"));
        Film driveToSurvive = new Film();
        String driveToSurviveTitle = "DRIVE TO SURVIVE";
        String driveToSurviveDescription = "Television documentary series produced in a collaboration between " +
                "Netflix and Formula One, to give a behind-the-scenes look at the drivers and races of the " +
                "Formula One World Championship.";
        driveToSurvive.setTitle(driveToSurviveTitle);
        driveToSurvive.setDescription(driveToSurviveDescription);
        driveToSurvive.setReleaseYear(Year.of(2019));
        driveToSurvive.setLanguage(english);
        driveToSurvive.setRentalDuration(3);
        driveToSurvive.setRentalRate(BigDecimal.valueOf(5.99));
        driveToSurvive.setLength(46);
        driveToSurvive.setReplacementCost(BigDecimal.valueOf(34.99));
        driveToSurvive.setRating(Rating.PG13);
        driveToSurvive.setSpecialFeatures(Set.of(Feature.COMMENTARIES));
        driveToSurvive.setCategories(categories);
        driveToSurvive.setActors(actors);
        appContainer.filmDAO.create(driveToSurvive);

        FilmText filmText = new FilmText();
        filmText.setId(driveToSurvive.getId());
        filmText.setFilm(driveToSurvive);
        filmText.setTitle(driveToSurviveTitle);
        filmText.setDescription(driveToSurviveDescription);
        appContainer.filmTextDAO.create(filmText);

        return driveToSurvive;
    }

    private Set<Actor> createNewActors() {
        Actor christian = Actor.builder()
                .firstName("Christian")
                .lastName("Horner")
                .build();
        Actor guenther = Actor.builder()
                .firstName("Guenther")
                .lastName("Steiner")
                .build();
        Actor max = Actor.builder()
                .firstName("Max")
                .lastName("Verstappen")
                .build();
        Actor sergio = Actor.builder()
                .firstName("Sergio")
                .lastName("Perez")
                .build();
        Actor kevin = Actor.builder()
                .firstName("Kevin")
                .lastName("Magnussen")
                .build();
        Actor nico = Actor.builder()
                .firstName("Nico")
                .lastName("Hülkenberg")
                .build();
        Actor will = Actor.builder()
                .firstName("Will")
                .lastName("Buxton")
                .build();
        Set<Actor> actors = Set.of(christian, guenther, max, sergio, kevin, nico, will);
        actors.forEach(appContainer.actorDAO::create);
        return actors;
    }
}
