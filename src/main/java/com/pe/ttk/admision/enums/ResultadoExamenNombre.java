package com.pe.ttk.admision.enums;

import java.util.HashMap;
import java.util.Map;

public enum ResultadoExamenNombre {
    APROBADO(1),
    DESAPROBADO(2),
    OBSERVADO(3);
    private final int value;
    private static Map map = new HashMap<>();
    private ResultadoExamenNombre(int value) {
        this.value = value;
    }
    static {
        for (ResultadoExamenNombre resultadoExamenNombre : ResultadoExamenNombre.values()) {
            map.put(resultadoExamenNombre.value, resultadoExamenNombre);
        }
    }

    public static ResultadoExamenNombre valueOf(int resultadoExamenNombre) {
        return (ResultadoExamenNombre) map.get(resultadoExamenNombre);
    }
    public int getValue() {
        return value;
    }
}
