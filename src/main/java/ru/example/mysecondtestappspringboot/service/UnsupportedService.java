package ru.example.mysecondtestappspringboot.service;

import org.springframework.stereotype.Service;
import ru.example.mysecondtestappspringboot.exeption.UnsupportedCodeException;
import ru.example.mysecondtestappspringboot.model.Request;
@Service
public interface UnsupportedService {
    void unsupp(Request request) throws UnsupportedCodeException;
}
