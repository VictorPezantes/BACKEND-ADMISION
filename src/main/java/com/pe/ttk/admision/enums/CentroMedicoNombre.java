package com.pe.ttk.admision.enums;

public enum CentroMedicoNombre {
    CENTRO_MEDICO_TEST;
    private static CentroMedicoNombre[] values = null;
    public static CentroMedicoNombre fromInt(int i) {
        if(CentroMedicoNombre.values == null) {
            CentroMedicoNombre.values = CentroMedicoNombre.values();
        }
        return CentroMedicoNombre.values[i-1];
    }
}
