package com.pe.ttk.admision.enums;

import java.util.HashMap;
import java.util.Map;

public enum CentroMedicoNombre {
    CENTRO_MEDICO_TEST(1);
    private final int value;
    private static Map map = new HashMap<>();
    private CentroMedicoNombre(int value) {
        this.value = value;
    }
    static {
        for (CentroMedicoNombre centroMedicoNombre : CentroMedicoNombre.values()) {
            map.put(centroMedicoNombre.value, centroMedicoNombre);
        }
    }

    public static CentroMedicoNombre valueOf(int centroMedicoNombre) {
        return (CentroMedicoNombre) map.get(centroMedicoNombre);
    }
    public int getValue() {
        return value;
    }
}
