package com.pe.ttk.admision.entity.master;

import com.pe.ttk.admision.enums.TipoDatoAcademicoNombre;
import com.pe.ttk.admision.enums.TipoExamenNombre;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class TipoDatoAcademico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoDatoAcademicoNombre tipoDatoAcademicoNombre;
    private Integer estado;

    public TipoDatoAcademico(){super();}
    public TipoDatoAcademico(@NotNull TipoDatoAcademicoNombre tipoDatoAcademicoNombre) {
        super();
        this.tipoDatoAcademicoNombre = tipoDatoAcademicoNombre;
        this.estado = 1;
        this.id = tipoDatoAcademicoNombre.ordinal()+1;
    }
}
