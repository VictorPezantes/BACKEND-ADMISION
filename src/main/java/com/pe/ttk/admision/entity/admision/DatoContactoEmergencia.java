package com.pe.ttk.admision.entity.admision;

import com.pe.ttk.admision.entity.master.Parentesco;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class DatoContactoEmergencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "postulanteId", referencedColumnName = "id")
    private PostulanteEntity postulante;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parentescoId", referencedColumnName = "id")
    private Parentesco parentesco;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String celular;
    private String telefono;
    private String email;
}
