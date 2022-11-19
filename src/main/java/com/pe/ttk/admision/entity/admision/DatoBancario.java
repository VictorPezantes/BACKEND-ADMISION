package com.pe.ttk.admision.entity.admision;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class DatoBancario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "postulanteId", referencedColumnName = "id")
    private PostulanteEntity postulante;
    private String moneda;
    private String banco;
    private String cuenta;
    private String cci;
    private String observacion;
    private String ruc;
    private String claveSol;
}
