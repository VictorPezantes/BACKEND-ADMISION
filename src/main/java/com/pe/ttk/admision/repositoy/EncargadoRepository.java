package com.pe.ttk.admision.repositoy;


import com.pe.ttk.admision.dto.Mensaje;
import com.pe.ttk.admision.entity.admision.PostulanteEntity;
import com.pe.ttk.admision.entity.master.Encargado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EncargadoRepository extends JpaRepository<Encargado, Long> {

    Optional<Encargado> findByEmail(String email);

    boolean existsByEmail(String email);
}
