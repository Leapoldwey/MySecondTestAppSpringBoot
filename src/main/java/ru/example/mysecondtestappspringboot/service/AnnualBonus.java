package ru.example.mysecondtestappspringboot.service;

import org.springframework.stereotype.Service;
import ru.example.mysecondtestappspringboot.model.Positions;
@Service
public interface AnnualBonus {
    double calculate(Positions positions, double salary, double bonus, int workDays);
}
