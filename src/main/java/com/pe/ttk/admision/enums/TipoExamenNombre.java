package com.pe.ttk.admision.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoExamenNombre {
    GENERAL(1);
    private final int value;
    private static Map map = new HashMap<>();
    private TipoExamenNombre(int value) {
        this.value = value;
    }
    static {
        for (TipoExamenNombre tipoExamenNombre : TipoExamenNombre.values()) {
            map.put(tipoExamenNombre.value, tipoExamenNombre);
        }
    }

    public static TipoExamenNombre valueOf(int tipoExamenNombre) {
        return (TipoExamenNombre) map.get(tipoExamenNombre);
    }
    public int getValue() {
        return value;
    }
}
