package com.pe.ttk.admision.repository.impl;

import com.pe.ttk.admision.repository.ExamenRepositoryPersonalizado;
import com.pe.ttk.admision.entity.admision.ExamenEntity;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ExamenRepositoryPersonalizadoImpl implements ExamenRepositoryPersonalizado {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<ExamenEntity> listarExamenes(Pageable pageable, String buscador, List subEstado, String fechaInformeMedico, String fechaProgramada) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ExamenEntity> query = cb.createQuery(ExamenEntity.class);
        Root<ExamenEntity> t = query.from(ExamenEntity.class);
        List<Predicate> condiciones = new ArrayList<>();
        if(!buscador.isBlank()) {
            condiciones.add(cb.like(t.get("titulo"), "%" + buscador + "%"));
        }
        if(!fechaInformeMedico.isBlank()){
            condiciones.add(cb.like(cb.function("date_format", String.class, t.get("fechaInformeMedico"),
                    cb.literal("%d/%m/%Y")), "%"+fechaInformeMedico+"%"));
        }
        if(!fechaProgramada.isBlank()){
            condiciones.add(cb.like(cb.function("date_format", String.class, t.get("fechaProgramada"),
                    cb.literal("%d/%m/%Y")), "%"+fechaProgramada+"%"));
        }
        if(!subEstado.isEmpty()) {
            condiciones.add(cb.and(t.get("subEstado").get("id").in(subEstado)));
        }
        query.select(t)
                .where(cb.and(condiciones.toArray(new Predicate[0])));

        return entityManager.createQuery(query).getResultList();
    }
}
