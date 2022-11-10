package com.pe.ttk.admision.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoPostulanteNombre {
    INGRESADO(1),
    VERIFICACION(2),
    ENTREVISTA_PERSONAL(3),
    FUERA_DEL_PROCESO(4),
    EXAMEN_MEDICO(5),
    REFERENCIAS_PERSONALES(6),
    POLIGRAFIA(7),
    EVALUACION(8),
    ALTA_EMPRESA(9);
    private final int value;
    private static Map map = new HashMap<>();
    private EstadoPostulanteNombre(int value) {
        this.value = value;
    }
    static {
        for (EstadoPostulanteNombre estadoResultadoNombre : EstadoPostulanteNombre.values()) {
            map.put(estadoResultadoNombre.value, estadoResultadoNombre);
        }
    }

    public static EstadoPostulanteNombre valueOf(int estadoResultadoNombre) {
        return (EstadoPostulanteNombre) map.get(estadoResultadoNombre);
    }
    public int getValue() {
        return value;
    }
}
