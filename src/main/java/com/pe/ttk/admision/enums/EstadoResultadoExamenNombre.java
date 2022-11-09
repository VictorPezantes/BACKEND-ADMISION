package com.pe.ttk.admision.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoResultadoExamenNombre {
    APROBADO(1),
    DESAPROBADO(2),
    OBSERVADO(3);
    private final int value;
    private static Map map = new HashMap<>();
    private EstadoResultadoExamenNombre(int value) {
        this.value = value;
    }
    static {
        for (EstadoResultadoExamenNombre resultadoExamenNombre : EstadoResultadoExamenNombre.values()) {
            map.put(resultadoExamenNombre.value, resultadoExamenNombre);
        }
    }

    public static EstadoResultadoExamenNombre valueOf(int resultadoExamenNombre) {
        return (EstadoResultadoExamenNombre) map.get(resultadoExamenNombre);
    }
    public int getValue() {
        return value;
    }
}
