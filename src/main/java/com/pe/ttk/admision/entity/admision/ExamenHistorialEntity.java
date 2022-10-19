package com.pe.ttk.admision.entity.admision;

import com.pe.ttk.admision.entity.master.CentroMedico;
import com.pe.ttk.admision.entity.master.EstadoResultadoExamen;
import com.pe.ttk.admision.entity.master.SubEstado;
import com.pe.ttk.admision.entity.master.TipoExamen;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "examen_historial")
public class ExamenHistorialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @NotEmpty
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @NotEmpty
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    @NotEmpty
    private String dni;
    @NotEmpty
    @Column(name = "fecha_programada")
    private Date fechaProgramada;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "resultadoExamenId", referencedColumnName = "id",nullable = true)
    private EstadoResultadoExamen estadoResultadoExamen;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subEstadoId", referencedColumnName = "id")
    private SubEstado subEstado;
    private Date fechaInformeMedico;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipoExamenId", referencedColumnName = "id")
    private TipoExamen tipoExamen;
    private String observacion;
    private String emailNotificacionPostulante;
    private Date fechaNotificacion;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "centroMedicoId", referencedColumnName = "id")
    private CentroMedico centroMedico;
    private String emailNotificacionCentroMedico;
    private boolean autorizadoGerencia;
}
