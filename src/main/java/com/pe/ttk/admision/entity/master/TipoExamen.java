package com.pe.ttk.admision.entity.master;

import com.pe.ttk.admision.enums.TipoExamenNombre;
import com.pe.ttk.admision.security.enums.RolNombre;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class TipoExamen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoExamenNombre tipoExamenNombre;
    private Integer estado;

    public TipoExamen(){super();}
    public TipoExamen(@NotNull TipoExamenNombre tipoExamenNombre) {
        super();
        this.tipoExamenNombre = tipoExamenNombre;
        this.estado = 1;
        this.id = tipoExamenNombre.ordinal()+1;
    }
}
