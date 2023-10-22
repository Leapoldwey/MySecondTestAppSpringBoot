package ru.example.mysecondtestappspringboot.service;

import org.springframework.stereotype.Service;
import ru.example.mysecondtestappspringboot.exeption.UnsupportedCodeException;
import ru.example.mysecondtestappspringboot.model.Request;
@Service
public class RequestUnsupportedService implements UnsupportedService {
    @Override
    public void unsupp(Request request) throws UnsupportedCodeException {
        if (request.getUid().equals("123")) {
            throw new UnsupportedCodeException();
        }
    }
}
