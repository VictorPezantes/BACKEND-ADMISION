package com.pe.ttk.admision.entity.admision;

import com.pe.ttk.admision.entity.master.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "historial_examen")
public class HistorialExamen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "examenId", referencedColumnName = "id")
    private ExamenEntity examen;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "postulanteId", referencedColumnName = "id")
    private PostulanteEntity postulante;
    @NotEmpty
    @Column(name = "fecha_programada")
    private Date fechaProgramada;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subEstadoId", referencedColumnName = "id")
    private SubEstado subEstado;
    private Date fechaInformeMedico;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipoExamenId", referencedColumnName = "id")
    private TipoExamen tipoExamen;
    private String observaciones;
    private String emailNotificacion;
    private Date fechaNotificacion;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "centroMedicoId", referencedColumnName = "id")
    private CentroMedico centroMedico;
    private String autorizoGerencia;
    private Date fechaCambioEstado;
}
