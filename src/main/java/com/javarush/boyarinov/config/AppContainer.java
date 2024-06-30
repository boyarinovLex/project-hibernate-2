package com.javarush.boyarinov.config;

import com.javarush.boyarinov.dao.*;

public class AppContainer {

    public final SessionCreator sessionCreator = new SessionCreator();
    public final ActorDAO actorDAO = new ActorDAO(sessionCreator);
    public final AddressDAO addressDAO = new AddressDAO(sessionCreator);
    public final CategoryDAO categoryDAO = new CategoryDAO(sessionCreator);
    public final CityDAO cityDAO = new CityDAO(sessionCreator);
    public final CountyDAO countyDAO = new CountyDAO(sessionCreator);
    public final CustomerDAO customerDAO = new CustomerDAO(sessionCreator);
    public final FilmDAO filmDAO = new FilmDAO(sessionCreator);
    public final FilmTextDAO filmTextDAO = new FilmTextDAO(sessionCreator);
    public final InventoryDAO inventoryDAO = new InventoryDAO(sessionCreator);
    public final LanguageDAO languageDAO = new LanguageDAO(sessionCreator);
    public final PaymentDAO paymentDAO = new PaymentDAO(sessionCreator);
    public final RentalDAO rentalDAO = new RentalDAO(sessionCreator);
    public final StaffDAO staffDAO = new StaffDAO(sessionCreator);
    public final StoreDAO storeDAO = new StoreDAO(sessionCreator);

}
