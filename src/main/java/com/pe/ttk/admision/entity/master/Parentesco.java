package com.pe.ttk.admision.entity.master;

import com.pe.ttk.admision.enums.EstadoOfertaNombre;
import com.pe.ttk.admision.enums.ParentescoNombre;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "parentesco")
public class Parentesco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private ParentescoNombre parentescoNombre;
    private Integer estado;
    public Parentesco(){super();}
    public Parentesco(@NotNull ParentescoNombre parentescoNombre) {
        super();
        this.parentescoNombre = parentescoNombre;
        this.estado = 1;
        this.id = parentescoNombre.ordinal()+1;
    }
}
