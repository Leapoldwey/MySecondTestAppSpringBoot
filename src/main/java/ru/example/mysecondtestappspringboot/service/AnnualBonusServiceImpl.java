package ru.example.mysecondtestappspringboot.service;

import org.springframework.stereotype.Service;
import ru.example.mysecondtestappspringboot.model.Positions;
import ru.example.mysecondtestappspringboot.util.LeapYearOrNot;


@Service
public class AnnualBonusServiceImpl implements AnnualBonus{
    @Override
    public double calculate(Positions positions, double salary, double bonus, int workDays) {

        return salary * bonus * LeapYearOrNot.leapYearOrNot() * positions.getPositionsCoefficient() / workDays;
    }
}
