package com.pe.ttk.admision.entity.master;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer estado;

}
