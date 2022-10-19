package com.pe.ttk.admision.enums;

import java.util.HashMap;
import java.util.Map;

public enum SubEstadoNombre {
    PENDIENTE(1),
    PROGRAMADO(2),
    APROBADO(3),
    CANCELADO(4),
    DESAPROBADO(5),
    OBSERVADO(6),
    REPROGRAMADO(7);
    private final int value;
    private static Map map = new HashMap<>();
    private SubEstadoNombre(int value) {
        this.value = value;
    }
    static {
        for (SubEstadoNombre subEstadoNombre : SubEstadoNombre.values()) {
            map.put(subEstadoNombre.value, subEstadoNombre);
        }
    }

    public static SubEstadoNombre valueOf(int subEstadoNombre) {
        return (SubEstadoNombre) map.get(subEstadoNombre);
    }
    public int getValue() {
        return value;
    }
}
