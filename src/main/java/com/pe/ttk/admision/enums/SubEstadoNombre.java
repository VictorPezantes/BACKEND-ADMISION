package com.pe.ttk.admision.enums;

public enum SubEstadoNombre {
    PENDIENTE,
    PROGRAMADO,
    APROBADO,
    CANCELADO,
    DESAPROBADO,
    OBSERVADO,
    REPROGRAMADO;
    private static SubEstadoNombre[] values = null;
    public static SubEstadoNombre fromInt(int i) {
        if(SubEstadoNombre.values == null) {
            SubEstadoNombre.values = SubEstadoNombre.values();
        }
        return SubEstadoNombre.values[i-1];
    }
}
