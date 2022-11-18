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
@Table(name = "dato_academico")
public class DatoAcademico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "postulanteId", referencedColumnName = "id")
    private PostulanteEntity postulante;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipoDatoAcademicoId", referencedColumnName = "id")
    private TipoDatoAcademico tipoDatoAcademico;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nivelEstudioId", referencedColumnName = "id")
    private NivelEstudio nivelEstudio;
    private String centroEducativo;
    private Date fechaInicio;
    private Date fechaTermino;
    private String direccion;
    @NotEmpty
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "distritoId", referencedColumnName = "id")
    private Distrito distrito;
    @NotEmpty
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "provinciaId", referencedColumnName = "id")
    private Provincia provincia;
    @ManyToOne(fetch = FetchType.EAGER)
    @NotEmpty
    @JoinColumn(name = "departamentoId", referencedColumnName = "id")
    private Departamento departamento;
}
