package com.bank.commons;

public class ValidateData {
    public static boolean string(String value, String fieldName) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("El campo " + fieldName + " no puede estar vacío");
        }
        return true;
    }
}
