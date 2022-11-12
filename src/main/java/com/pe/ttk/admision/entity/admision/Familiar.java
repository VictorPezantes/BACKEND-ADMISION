package com.pe.ttk.admision.entity.admision;

import com.pe.ttk.admision.entity.master.Departamento;
import com.pe.ttk.admision.entity.master.Distrito;
import com.pe.ttk.admision.entity.master.Parentesco;
import com.pe.ttk.admision.entity.master.Provincia;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "familiar")
public class Familiar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String primerApellido;
    private String segundoApellido;
    private String primerNombre;
    private String segundoNombre;
    private String dni;
    private Date fechaNacimiento;
    private Date lugarNacimiento;
    private String ocupacion;
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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parentescoId", referencedColumnName = "id")
    private Parentesco parentesco;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "postulanteId", referencedColumnName = "id")
    private PostulanteEntity postulante;
}
