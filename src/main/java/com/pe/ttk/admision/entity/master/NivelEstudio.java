package com.pe.ttk.admision.entity.master;

import com.pe.ttk.admision.enums.NivelEstudioNombre;
import com.pe.ttk.admision.enums.TipoDatoAcademicoNombre;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class NivelEstudio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private NivelEstudioNombre nivelEstudioNombre;
    private Integer estado;

    public NivelEstudio(){super();}
    public NivelEstudio(@NotNull NivelEstudioNombre nivelEstudioNombre) {
        super();
        this.nivelEstudioNombre = nivelEstudioNombre;
        this.estado = 1;
        this.id = nivelEstudioNombre.ordinal()+1;
    }
}
