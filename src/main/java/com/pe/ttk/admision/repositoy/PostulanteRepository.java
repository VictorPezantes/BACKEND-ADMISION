package com.pe.ttk.admision.repositoy;

import com.pe.ttk.admision.entity.admision.PostulanteEntity;
import com.pe.ttk.admision.entity.admision.PostulanteEntityExt;
import org.springframework.beans.factory.annotation.Autowired;
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
            "inner join Provincia pr on p.idProvincia=p.id " +
            "inner join Departamento de on p.idDepartamento=de.id " +
            "where p.estado = :estado or :estado is null")
    List<PostulanteEntityExt> findByEstado(@Param("estado") Integer estado, Pageable pageable);

    boolean existsByDniAndEstado(String dni, Integer estado);
    @Query(value = "SELECT NEW com.pe.ttk.admision.entity.admision.PostulanteEntityExt(p,e.subEstado.id) FROM PostulanteEntity p "
            + "LEFT JOIN ExamenEntity e " +
            " ON p.id = e.postulante.id " +
            " WHERE ((e.id is null AND :estadoExamen is null) OR (e.subEstado.id =:estadoExamen)) " +
            " AND (DATE(e.fechaInformeMedico)=DATE(:fechaInformeMedico) OR :fechaInformeMedico is null)" +
            " AND (DATE(e.fechaProgramada)=DATE(:fechaProgramada) OR :fechaProgramada is null)" +
            " AND ((p.apellidoPaterno LIKE %:filtro% or p.apellidoMaterno LIKE %:filtro% or p.primerNombre LIKE %:filtro% or p.segundoNombre LIKE %:filtro%) OR :filtro is null )")
    List<PostulanteEntityExt> findPostulanteExamen(@Param("estadoExamen")Integer estadoExamen,
                                                   @Param("fechaInformeMedico") Date fechaInformeMedico,
                                                   @Param("fechaProgramada") Date fechaProgramada,
                                                   @Param("filtro") String filtro);
}
