package com.pe.ttk.admision.entity.admision;

import com.pe.ttk.admision.entity.master.CentroMedico;
import com.pe.ttk.admision.entity.master.EstadoResultadoExamen;
import com.pe.ttk.admision.entity.master.SubEstado;
import com.pe.ttk.admision.entity.master.TipoExamen;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "examen")
public class ExamenEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private Date fechaInformeMedico;
    private Date fechaProgramada;
    private String observacion;
    private Date fechaResultado;
    private String resultadoExamen;

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
    @JoinColumn(name = "resultadoExamenId", referencedColumnName = "id",nullable = true)
    private EstadoResultadoExamen estadoResultadoExamen;
}
