package com.pe.ttk.admision.repositoy;

import com.pe.ttk.admision.entity.admision.PostulanteEntity;
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
    List<PostulanteEntity> findByEstado(Integer estado, Pageable pageable);

    boolean existsByDniAndEstado(String dni, Integer estado);
    @Query(value = "select * from Postulante "
            + "where (:estado is null or estado = :estado)  "
            + "and (:fechaPostulacion is null or DATE(fecha_postulacion) = DATE(:fechaPostulacion) ) "
            + "and (:dni is null or dni = :dni)",
            nativeQuery = true)
    List<PostulanteEntity> findByEstadoAndFechaPostulacionAndDni(Integer estado, Date fechaPostulacion, String dni);
}
