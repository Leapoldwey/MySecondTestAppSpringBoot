package ru.example.mysecondtestappspringboot.service;


import org.springframework.stereotype.Service;
import ru.example.mysecondtestappspringboot.model.Request;
@Service
public interface ModifyRequestService {
    void modify(Request request);
}
