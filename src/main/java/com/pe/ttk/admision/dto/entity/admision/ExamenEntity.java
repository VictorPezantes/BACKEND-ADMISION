package com.pe.ttk.admision.dto.entity.admision;

import com.pe.ttk.admision.dto.entity.master.*;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "examen")
public class ExamenEntity implements Serializable {
    @Id
    private Long id;
    private Date fecha;
    private Date fechaInformeMedico;
    private Date fechaProgramada;
    private String observacion;
    private Date fechaResultado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "centroMedicoId", referencedColumnName = "id")
    private CentroMedico centroMedico;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipoExamenId", referencedColumnName = "id")
    private TipoExamen tipoExamen;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "postulanteId", referencedColumnName = "id")
    private PostulanteEntity postulante;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subEstadoId", referencedColumnName = "id")
    private SubEstado subEstado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "resultadoExamenId", referencedColumnName = "id")
    private ResultadoExamen resultadoExamen;
}
