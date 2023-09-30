package ru.example.mysecondtestappspringboot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.example.mysecondtestappspringboot.exeption.ValidationFailedException;
@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
}
