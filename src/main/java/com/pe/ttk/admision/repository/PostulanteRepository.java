package com.pe.ttk.admision.repository;

import com.pe.ttk.admision.entity.admision.PostulanteEntity;
import com.pe.ttk.admision.entity.admision.PostulanteEntityExt;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostulanteRepository extends JpaRepository<PostulanteEntity,Long> {


    List<PostulanteEntity> findAll();
    /*List<PostulanteMapping> findByQueryString(@Param("dni") String dni,@Param("distrito") String distrito,
                                              @Param("provincia") String provincia, @Param("departamento") String departamento);
*/
    PostulanteEntity findByDni(@Param("dni") String dni);
    @Query("SELECT NEW com.pe.ttk.admision.entity.admision.PostulanteEntityExt(p, d.nombre ,pr.nombre ,de.nombre) from PostulanteEntity p " +
            "inner join Distrito d on p.idDistrito=d.id " +
            "inner join Provincia pr on p.idProvincia=pr.id " +
            "inner join Departamento de on p.idDepartamento=de.id ")
    List<PostulanteEntityExt> findByEstado(Integer estadoId, Pageable pageable);

    boolean existsByDniAndActivo(String dni,boolean activo);
    @Query(value = "SELECT NEW com.pe.ttk.admision.entity.admision.PostulanteEntityExt(po, di.nombre ,pr.nombre ,de.nombre, e, en) " +
            "FROM PostulanteEntity po " +
            "LEFT JOIN ExamenEntity e  ON po.id = e.postulante.id " +
            "LEFT JOIN Encargado en ON en.id = po.encargado.id " +
            "LEFT join Distrito di on po.idDistrito=di.id " +
            "LEFT join Provincia pr on po.idProvincia=pr.id " +
            "LEFT join Departamento de on po.idDepartamento=de.id " +
            " WHERE " +
            "(:fechaInformeMedico is null OR (DATE(e.fechaInformeMedico)=DATE(:fechaInformeMedico))) AND" +
            " (:fechaProgramada is null OR (DATE(e.fechaProgramada)=DATE(:fechaProgramada))) AND" +
            " (:filtro is null or (po.apellidoPaterno LIKE %:filtro% or po.apellidoMaterno LIKE %:filtro% or po.primerNombre LIKE %:filtro% or po.segundoNombre LIKE %:filtro%) ) AND" +
            " (:estadoExamenId is null OR (po.subEstado.id = :estadoExamenId))" +
            " AND (:estadoPostulanteId is null OR (po.estadoPostulante.id = :estadoPostulanteId))" +
            " AND (:encargadoId is null OR (en.id =:encargadoId))" +
            " AND (:cargoId is null OR (po.oferta.cargoOferta.id = :cargoId))" +
            " AND (:postulanteId is null OR (po.id = :postulanteId)) ")
    List<PostulanteEntityExt> findPostulanteFiltro(@Param("estadoExamenId")Integer estadoExamenId,
                                                   @Param("fechaInformeMedico") Date fechaInformeMedico,
                                                   @Param("fechaProgramada") Date fechaProgramada,
                                                   @Param("filtro") String filtro,
                                                   @Param("estadoPostulanteId") Integer estadoPostulanteId,
                                                   @Param("encargadoId") Long encargadoId,
                                                   @Param("cargoId") Long cargoId,
                                                   @Param("postulanteId") Long postulanteId,
                                                   Pageable pageable);
}
