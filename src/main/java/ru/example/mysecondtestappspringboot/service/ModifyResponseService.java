package ru.example.mysecondtestappspringboot.service;

import org.springframework.stereotype.Service;
import ru.example.mysecondtestappspringboot.model.Response;
@Service
public interface ModifyResponseService {
    Response modify(Response response);
}
