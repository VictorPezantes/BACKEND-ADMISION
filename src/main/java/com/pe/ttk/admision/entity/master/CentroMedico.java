package com.pe.ttk.admision.entity.master;

import com.pe.ttk.admision.enums.CentroMedicoNombre;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class CentroMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private CentroMedicoNombre  centroMedicoNombre;
    private Integer estado;
    private String Direccion;
    private String email;
    public CentroMedico(){super();}
    public CentroMedico(@NotNull CentroMedicoNombre centroMedicoNombre) {
        super();
        this.centroMedicoNombre = centroMedicoNombre;
        this.estado = 1;
        this.id = centroMedicoNombre.ordinal()+1;
    }
}
