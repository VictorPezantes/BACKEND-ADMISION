package com.pe.ttk.admision.enums;

import java.util.HashMap;
import java.util.Map;

public enum ParentescoNombre {
    HIJO(1),
    PAREJA(2),
    PADRE(3),
    HERMANO(4),
    SUEGRO(5);
    private final int value;
    private static Map map = new HashMap<>();
    private ParentescoNombre(int value) {
        this.value = value;
    }
    static {
        for (ParentescoNombre parentescoNombre : ParentescoNombre.values()) {
            map.put(parentescoNombre.value, parentescoNombre);
        }
    }
}
