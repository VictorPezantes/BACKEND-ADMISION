package com.pe.ttk.admision.repositoy;

import com.pe.ttk.admision.entity.admision.PostulanteEntity;
import com.pe.ttk.admision.entity.admision.PostulanteEntityExt;
import org.springframework.data.domain.Page;
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
            "inner join Departamento de on p.idDepartamento=de.id " +
            "where p.estado = :estadoId or :estadoId is null")
    List<PostulanteEntityExt> findByEstado(@Param("estadoId") Integer estadoId, Pageable pageable);

    boolean existsByDniAndEstado(String dni, Integer estado);
    @Query(value = "SELECT NEW com.pe.ttk.admision.entity.admision.PostulanteEntityExt(p,e.subEstado.id, d.nombre ,pr.nombre ,de.nombre,e) " +
            "FROM PostulanteEntity p " +
            "LEFT join Distrito d on p.idDistrito=d.id " +
            "LEFT join Provincia pr on p.idProvincia=pr.id " +
            "LEFT join Departamento de on p.idDepartamento=de.id " +
            "LEFT JOIN ExamenEntity e " +
            " ON p.id = e.postulante.id" +
            " WHERE " +
            "(:fechaInformeMedico is null OR (DATE(e.fechaInformeMedico)=DATE(:fechaInformeMedico))) AND" +
            " (:fechaProgramada is null OR (DATE(e.fechaProgramada)=DATE(:fechaProgramada))) AND" +
            " (:filtro is null or (p.apellidoPaterno LIKE %:filtro% or p.apellidoMaterno LIKE %:filtro% or p.primerNombre LIKE %:filtro% or p.segundoNombre LIKE %:filtro%) ) AND" +
            " (:estadoId is null or (p.estado = :estadoId)) AND" +
            " (:estadoExamenId is null OR (e.subEstado.id = :estadoExamenId))")
    List<PostulanteEntityExt> findPostulanteFiltro(@Param("estadoExamenId")Integer estadoExamenId,
                                                   @Param("fechaInformeMedico") Date fechaInformeMedico,
                                                   @Param("fechaProgramada") Date fechaProgramada,
                                                   @Param("filtro") String filtro,
                                                   @Param("estadoId") Integer estadoId,
                                                   Pageable pageable);
}
