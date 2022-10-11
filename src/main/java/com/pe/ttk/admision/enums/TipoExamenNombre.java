package com.pe.ttk.admision.enums;

public enum TipoExamenNombre {
    GENERAL;
    private static TipoExamenNombre[] values = null;
    public static TipoExamenNombre fromInt(int i) {
        if(TipoExamenNombre.values == null) {
            TipoExamenNombre.values = TipoExamenNombre.values();
        }
        return TipoExamenNombre.values[i-1];
    }
}
