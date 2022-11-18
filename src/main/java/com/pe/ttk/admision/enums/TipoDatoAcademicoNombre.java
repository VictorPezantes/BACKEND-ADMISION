package com.pe.ttk.admision.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoDatoAcademicoNombre {
    ESTUDIOS_BASICOS(1),
    ESTUDIOS_SUPERIORES(2),
    OTROS_ESTUDIOS(3);
    private final int value;
    private static Map map = new HashMap<>();
    private TipoDatoAcademicoNombre(int value) {
        this.value = value;
    }
    static {
        for (TipoDatoAcademicoNombre tipoDatoAcademicoNombre : TipoDatoAcademicoNombre.values()) {
            map.put(tipoDatoAcademicoNombre.value, tipoDatoAcademicoNombre);
        }
    }

    public static TipoDatoAcademicoNombre valueOf(int tipoDatoAcademicoNombre) {
        return (TipoDatoAcademicoNombre) map.get(tipoDatoAcademicoNombre);
    }
    public int getValue() {
        return value;
    }
}
