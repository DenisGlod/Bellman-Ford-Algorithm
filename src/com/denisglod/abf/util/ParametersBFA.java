package com.denisglod.abf.util;

import org.jetbrains.annotations.Contract;

public enum ParametersBFA {
    SPACE(" "),
    WARNING("Предупреждение"),
    ERROR("Ошибка"),
    ABOUT("О программе"),
    PROGRAM_NAME("Алгоритм Беллмана-Форда"),
    EQUALS("="),
    COMMA(",");

    private final String paramName;

    ParametersBFA(String paramName) {
        this.paramName = paramName;
    }

    @Contract(pure = true)
    public String getParamName() {
        return paramName;
    }
}
