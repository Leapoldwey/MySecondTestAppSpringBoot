package ru.example.mysecondtestappspringboot.service;

import org.springframework.stereotype.Service;
import ru.example.mysecondtestappspringboot.model.Positions;


@Service
public interface QuarterlyBonus {
    double calculate(double salary, Positions positions, double bonus, int workDays);

}
