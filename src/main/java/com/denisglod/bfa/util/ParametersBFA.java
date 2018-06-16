package com.denisglod.bfa.util;

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

    public String getParamName() {
        return paramName;
    }
}
