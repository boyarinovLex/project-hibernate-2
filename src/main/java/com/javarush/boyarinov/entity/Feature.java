package com.javarush.boyarinov.entity;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum Feature {

    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted Scenes"),
    BEHIND_THE_SCENES("Behind the Scenes");

    private final String value;

    Feature(String value) {
        this.value = value;
    }

    public static Feature getFeatureBy(String value) {
        if (Objects.isNull(value) || value.isEmpty()) {
            return null;
        }

        return Arrays.stream(Feature.values())
                .filter(feature -> feature.value.equals(value))
                .findFirst()
                .orElse(null);
    }
}
