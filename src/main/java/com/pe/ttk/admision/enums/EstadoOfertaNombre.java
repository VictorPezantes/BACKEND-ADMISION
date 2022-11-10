package com.pe.ttk.admision.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoOfertaNombre {
        PENDIENTE(1),
        APROBADO(2),
        RECHAZADO(3);
        private final int value;
        private static Map map = new HashMap<>();
    private EstadoOfertaNombre(int value) {
        this.value = value;
    }
        static {
        for (EstadoOfertaNombre estadoOfertaNombre : EstadoOfertaNombre.values()) {
            map.put(estadoOfertaNombre.value, estadoOfertaNombre);
        }
    }

        public static EstadoOfertaNombre valueOf(int estadoResultadoNombre) {
        return (EstadoOfertaNombre) map.get(estadoResultadoNombre);
    }
        public int getValue() {
        return value;
    }
}
