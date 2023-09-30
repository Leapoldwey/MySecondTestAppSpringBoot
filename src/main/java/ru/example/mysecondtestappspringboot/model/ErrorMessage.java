package ru.example.mysecondtestappspringboot.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorMessage {
    EMPTY(""),
    VALIDATION_MESSAGE("Ошибка валидации"),
    UNKNOWN_MESSAGE("Произошла неизвестаня ошибка"),
    UNSUPPORTED_MESSAGE("Данное значение не поддерживается");

    private final String description;

    ErrorMessage(String description) {
        this.description = description;
    }

    @JsonValue
    public String getDescription() {
        return description;
    }
}
