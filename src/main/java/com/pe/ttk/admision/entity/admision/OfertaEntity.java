package com.pe.ttk.admision.entity.admision;

import com.pe.ttk.admision.entity.master.Cargo;
import com.pe.ttk.admision.entity.master.Encargado;
import com.pe.ttk.admision.entity.master.EstadoOferta;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="oferta")
public class OfertaEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String titulo;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private String requisito;
    @Column(nullable = false)
    private Date fechaCreacion;
    private Date fechaActualizacion;
    private Date fechaPublicacion;
    private Date fechaDesactivado;
    @Column(nullable = false)
    private int cantidadPostulantes;
    private int estado;


    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name ="fk_estado", referencedColumnName = "id")
    private EstadoOferta estadoOferta;


    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name ="fk_creador", referencedColumnName = "id")
    private Encargado creadorOferta;


    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name ="fk_cargo", referencedColumnName = "id")
    private Cargo cargoOferta;


}
