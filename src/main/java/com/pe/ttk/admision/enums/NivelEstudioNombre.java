package com.pe.ttk.admision.enums;

import java.util.HashMap;
import java.util.Map;

public enum NivelEstudioNombre {
    PRIMARIA(1),
    SECUNDARIA(2),
    SERV_MILITAR(3),
    TECNICO(4),
    UNIVERSITARIO(5);
    private final int value;
    private static Map map = new HashMap<>();
    private NivelEstudioNombre(int value) {
        this.value = value;
    }
    static {
        for (NivelEstudioNombre nivelEstudioNombre : NivelEstudioNombre.values()) {
            map.put(nivelEstudioNombre.value, nivelEstudioNombre);
        }
    }

    public static NivelEstudioNombre valueOf(int nivelEstudioNombre) {
        return (NivelEstudioNombre) map.get(nivelEstudioNombre);
    }
    public int getValue() {
        return value;
    }
}
