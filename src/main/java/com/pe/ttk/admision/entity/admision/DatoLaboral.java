package com.pe.ttk.admision.entity.admision;

import com.pe.ttk.admision.entity.master.Departamento;
import com.pe.ttk.admision.entity.master.Distrito;
import com.pe.ttk.admision.entity.master.Provincia;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class DatoLaboral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "postulanteId", referencedColumnName = "id")
    private PostulanteEntity postulante;
    private String trabajo;
    private String puesto;
    private String empresa;
    private Date fechaInicio;
    private Date fechaTermino;
    private String direccion;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "distritoId", referencedColumnName = "id")
    private Distrito distrito;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pronvinciaId", referencedColumnName = "id")
    private Provincia provincia;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departamentoId", referencedColumnName = "id")
    private Departamento departamento;
    private String funciones;
}
