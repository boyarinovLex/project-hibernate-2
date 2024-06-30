package com.javarush.boyarinov.converter;

import com.javarush.boyarinov.entity.Rating;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

@Converter(autoApply = true)
public class RatingConverter implements AttributeConverter<Rating, String> {

    @Override
    public String convertToDatabaseColumn(Rating attribute) {
        return attribute.getValue();
    }

    @Override
    public Rating convertToEntityAttribute(String dbData) {
        return Arrays.stream(Rating.values())
                .filter(rating -> rating.getValue().equals(dbData))
                .findFirst()
                .orElse(null);
    }
}
