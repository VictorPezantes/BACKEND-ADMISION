package com.pe.ttk.admision.entity.admision;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class DatoEmbarque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "postulanteId", referencedColumnName = "id")
    private PostulanteEntity postulante;
    private String numeroEmbarque;
    private String buqueEmbarque;
    private String tecnicoACargo;
    private String trabajoARealizar;
    private Date fechaEmbarque;
    private Date fechaDesembarque;
}
