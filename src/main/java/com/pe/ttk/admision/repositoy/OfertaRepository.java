package com.pe.ttk.admision.repositoy;

import com.pe.ttk.admision.entity.master.Encargado;
import com.pe.ttk.admision.entity.master.Estado;
import com.pe.ttk.admision.entity.admision.OfertaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OfertaRepository extends PagingAndSortingRepository<OfertaEntity, Long>, OfertaRepositoryPersonalizado {


    @Query(" select o from OfertaEntity o"
            + " where o.titulo like %:titulo% ")
    List<OfertaEntity> findByTitulo(@Param("titulo") String titulo);

    List<OfertaEntity> findByEstadoOferta(Estado estado);

    List<OfertaEntity> findByCreadorOferta(Encargado encargado);
    List<OfertaEntity> findByfechaPublicacion(Date fechaPublicacion);

    Optional<OfertaEntity> findByIdAndEstado(Long id, Integer estado);
/*    @Query("SELECT o FROM OfertaEntity o"
            + " WHERE (:estado is null or o.estado = :estado) and (:descripcion is null or o.descripcion = :descripcion)"
            + " and (:fechaPublicacion is null or date(o.fechaPublicacion) = date(:fechaPublicacion) )"
            + " and (:fechaPublicacion is null or date(o.fechaPublicacion) = date(:fechaPublicacion) )"
            + " and (:idCreadorOferta is null or o.creadorOferta.id = :idCreadorOferta)")
    List<OfertaEntity> findAllByEstadoOrDescripcionLikeIgnoreCaseOrFechaPublicacion(Integer estado, String descripcion, Date fechaPublicacion, Long idCreadorOferta);*/

}
