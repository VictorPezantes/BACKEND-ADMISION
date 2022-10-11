package com.pe.ttk.admision.util.mapper;

import com.pe.ttk.admision.dto.PostulanteDto;
import com.pe.ttk.admision.entity.admision.PostulanteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostulanteMapper {

    PostulanteMapper INSTANCE = Mappers.getMapper(PostulanteMapper.class);

    PostulanteDto toPostulante(PostulanteEntity postulanteEntity);

    PostulanteEntity toPostulanteEntity(PostulanteDto postulanteDto);

}
