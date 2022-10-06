package com.pe.ttk.admision.repositoy;

import com.pe.ttk.admision.dto.entity.admision.ExamenEntity;
import com.pe.ttk.admision.dto.entity.master.SubEstado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface ExamenRepository extends PagingAndSortingRepository<ExamenEntity, Integer>, ExamenRepositoryPersonalizado {
    @Query(" select e from ExamenEntity e"
            + " where e.postulante.apellidoMaterno like %:busqueda% " +
            "or e.postulante.apellidoPaterno like %:busqueda% " +
            "or e.postulante.primerNombre like %:busqueda% " +
            "or e.postulante.segundoNombre like %:busqueda%")
    List<ExamenEntity> findByPostulanteNombre(@Param("busqueda")String busqueda);
    List<ExamenEntity> findByPostulante_Id(Long postulante_id);
    List<ExamenEntity> findBySubEstado(SubEstado subEstado);
    List<ExamenEntity> findByFechaInformeMedico(Date fechaInformeMedico);
    List<ExamenEntity> findByFechaProgramada(Date fechaProgramada);
}
