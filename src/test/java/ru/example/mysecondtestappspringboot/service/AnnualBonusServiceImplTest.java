package ru.example.mysecondtestappspringboot.service;

import org.junit.jupiter.api.Test;
import ru.example.mysecondtestappspringboot.model.Positions;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class AnnualBonusServiceImplTest {

    @Test
    void calculate() {
        Positions positions = Positions.HR;
        double bonus = 2.0;
        int workDay = 243;
        double salary = 100000.00;

        double result = new AnnualBonusServiceImpl().calculate(positions, salary, bonus, workDay);
        double expected = 360493.8271604938;
        assertThat(result).isEqualTo(expected);
    }
}