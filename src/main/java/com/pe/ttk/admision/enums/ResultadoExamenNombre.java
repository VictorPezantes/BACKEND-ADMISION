package com.pe.ttk.admision.enums;

public enum ResultadoExamenNombre {
    APROBADO,
    DESAPROBADO,
    OBSERVADO;
    private static ResultadoExamenNombre[] values = null;
    public static ResultadoExamenNombre fromInt(int i) {
        if(ResultadoExamenNombre.values == null) {
            ResultadoExamenNombre.values = ResultadoExamenNombre.values();
        }
        return ResultadoExamenNombre.values[i-1];
    }
}
