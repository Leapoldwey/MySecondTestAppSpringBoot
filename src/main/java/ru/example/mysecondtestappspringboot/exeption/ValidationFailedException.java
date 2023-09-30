package ru.example.mysecondtestappspringboot.exeption;

public class ValidationFailedException extends Exception {
    public ValidationFailedException(String message) {
        super(message);
    }
}
