package ru.example.mysecondtestappspringboot.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorCode {
    EMPTY(""),
    VALIDATION_CODE("ValidationException"),
    UNKNOWN_CODE("UnknownException"),
    UNSUPPORTED_CODE("UnsupportedException");

    private final String name;

    ErrorCode(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }
}
