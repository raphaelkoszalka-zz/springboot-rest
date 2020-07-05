package com.koszalka.crud.constants;

import lombok.Getter;

@Getter
public enum AppConstants {

    CONFLICT("conflcit"),
    ALREADY_EXISTS("exists"),
    SAVED("saved"),
    BAD_REQUEST("bad_request"),
    LOCALHOST("http://localhost:8080/v1/");

    private final String value;

    AppConstants(String value) {
        this.value = value;
    }

}
