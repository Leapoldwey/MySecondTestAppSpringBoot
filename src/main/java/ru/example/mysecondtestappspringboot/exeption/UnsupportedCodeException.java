package ru.example.mysecondtestappspringboot.exeption;

public class UnsupportedCodeException extends Exception {
    public UnsupportedCodeException() {
        super("Символ не может быть равен \"123\"");
    }
}
