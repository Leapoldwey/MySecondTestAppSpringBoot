package ru.example.mysecondtestappspringboot.service;

import org.springframework.stereotype.Service;
import ru.example.mysecondtestappspringboot.model.Positions;
import ru.example.mysecondtestappspringboot.util.LeapYearOrNot;

@Service
public class QuarterlyBonusServiceImpl implements QuarterlyBonus{
    @Override
    public double calculate(double salary, Positions positions, double bonus, int workDays) {
        if (positions.isManager()) {

            return ((salary * bonus * LeapYearOrNot.leapYearOrNot() * positions.getPositionsCoefficient() / workDays)
                    * 0.1);
        } else return 0.0;
    }
}
