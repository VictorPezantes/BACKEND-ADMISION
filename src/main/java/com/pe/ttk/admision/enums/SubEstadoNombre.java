package com.pe.ttk.admision.enums;

import java.util.HashMap;
import java.util.Map;

public enum SubEstadoNombre {
    PROGRAMADO(1),
    APROBADO(2),
    CANCELADO(3),
    DESAPROBADO(4),
    OBSERVADO(5),
    REPROGRAMADO(6),
    PENDIENTE(7);
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
