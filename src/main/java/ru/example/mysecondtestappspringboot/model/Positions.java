package ru.example.mysecondtestappspringboot.model;

import lombok.Getter;

@Getter
public enum Positions {
    DEV(2.2, false),
    HR(1.2, false),
    TL(2.6, true),
    CPA(2.0, false), //бухгалтер
    CRMO(2.5, true), //главный риск-менеджер
    CSO(2.2, false); //начальник службы безопасности

    private final double positionsCoefficient;
    private final boolean isManager;

    Positions(Double positionsCoefficient, boolean isManager) {
        this.positionsCoefficient = positionsCoefficient;
        this.isManager = isManager;
    }
}
