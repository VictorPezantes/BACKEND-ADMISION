package com.pe.ttk.admision.util.mapper.impl;

import com.pe.ttk.admision.dto.PostulanteDto;
import com.pe.ttk.admision.entity.admision.PostulanteEntity;
import com.pe.ttk.admision.entity.admision.PostulanteEntityExt;
import com.pe.ttk.admision.util.mapper.PostulanteMapper;

public class PostulanteMapperImpl implements PostulanteMapper {

    @Override
    public PostulanteDto toPostulanteFromEntity(PostulanteEntity postulanteEntity) {
        if ( postulanteEntity == null ) {
            return null;
        }

        PostulanteDto postulanteDto = new PostulanteDto();

        postulanteDto.setId( postulanteEntity.getId() );
        postulanteDto.setPrimerNombre( postulanteEntity.getPrimerNombre() );
        postulanteDto.setSegundoNombre( postulanteEntity.getSegundoNombre() );
        postulanteDto.setApellidoPaterno( postulanteEntity.getApellidoPaterno() );
        postulanteDto.setApellidoMaterno( postulanteEntity.getApellidoMaterno() );
        postulanteDto.setIdEstadoCivil( postulanteEntity.getIdEstadoCivil() );
        postulanteDto.setDni( postulanteEntity.getDni() );
        postulanteDto.setFechaNacimiento( postulanteEntity.getFechaNacimiento() );
        postulanteDto.setDireccion( postulanteEntity.getDireccion() );
        postulanteDto.setIdDistrito( postulanteEntity.getIdDistrito() );
        postulanteDto.setIdProvincia( postulanteEntity.getIdProvincia() );
        postulanteDto.setIdDepartamento( postulanteEntity.getIdDepartamento() );
        postulanteDto.setCelular( postulanteEntity.getCelular() );
        postulanteDto.setCelularFamiliar( postulanteEntity.getCelularFamiliar() );
        postulanteDto.setTelefonoFijo( postulanteEntity.getTelefonoFijo() );
        postulanteDto.setEmail( postulanteEntity.getEmail() );
        postulanteDto.setEmailSecundario( postulanteEntity.getEmailSecundario() );
        postulanteDto.setProfesion( postulanteEntity.getProfesion() );
        postulanteDto.setLugarEstudios( postulanteEntity.getLugarEstudios() );
        postulanteDto.setUltimoCursoRealizado( postulanteEntity.getUltimoCursoRealizado() );
        postulanteDto.setEmpresaCurso( postulanteEntity.getEmpresaCurso() );
        postulanteDto.setTrabajoReciente( postulanteEntity.getTrabajoReciente() );
        postulanteDto.setFechaIngresoTrabajoReciente( postulanteEntity.getFechaIngresoTrabajoReciente() );
        postulanteDto.setFechaSalidaTrabajoReciente( postulanteEntity.getFechaSalidaTrabajoReciente() );
        postulanteDto.setEmpresaTrabajoReciente( postulanteEntity.getEmpresaTrabajoReciente() );
        postulanteDto.setMotivoSalidaTrabajoReciente( postulanteEntity.getMotivoSalidaTrabajoReciente() );
        postulanteDto.setDisponibilidadViajar( postulanteEntity.getDisponibilidadViajar() );
        postulanteDto.setExperienciaRubro( postulanteEntity.getExperienciaRubro() );
        postulanteDto.setEstadoPostulacion( postulanteEntity.getEstadoPostulacion() );
        postulanteDto.setFechaPostulacion( postulanteEntity.getFechaPostulacion() );
        postulanteDto.setProcedencia( postulanteEntity.getProcedencia() );
        postulanteDto.setIdOferta( postulanteEntity.getIdOferta() );
        postulanteDto.setOfertaPostulada( postulanteEntity.getOfertaPostulada() );
        postulanteDto.setEstado( postulanteEntity.getEstado() );

        return postulanteDto;
    }

    @Override
    public PostulanteDto toPostulanteFromExtityExt(PostulanteEntityExt postulanteEntityExt) {
        if ( postulanteEntityExt == null ) {
            return null;
        }

        PostulanteDto postulanteDto = new PostulanteDto();

        postulanteDto.setId( postulanteEntityExt.getId() );
        postulanteDto.setPrimerNombre( postulanteEntityExt.getPrimerNombre() );
        postulanteDto.setSegundoNombre( postulanteEntityExt.getSegundoNombre() );
        postulanteDto.setApellidoPaterno( postulanteEntityExt.getApellidoPaterno() );
        postulanteDto.setApellidoMaterno( postulanteEntityExt.getApellidoMaterno() );
        postulanteDto.setIdEstadoCivil( postulanteEntityExt.getIdEstadoCivil() );
        postulanteDto.setDni( postulanteEntityExt.getDni() );
        postulanteDto.setFechaNacimiento( postulanteEntityExt.getFechaNacimiento() );
        postulanteDto.setDireccion( postulanteEntityExt.getDireccion() );
        postulanteDto.setIdDistrito( postulanteEntityExt.getIdDistrito() );
        postulanteDto.setDistritoDescripcion( postulanteEntityExt.getDistritoDescripcion() );
        postulanteDto.setIdProvincia( postulanteEntityExt.getIdProvincia() );
        postulanteDto.setProvinciaDescripcion( postulanteEntityExt.getProvinciaDescripcion() );
        postulanteDto.setIdDepartamento( postulanteEntityExt.getIdDepartamento() );
        postulanteDto.setDepartamentoDescripcion( postulanteEntityExt.getDepartamentoDescripcion() );
        postulanteDto.setCelular( postulanteEntityExt.getCelular() );
        postulanteDto.setCelularFamiliar( postulanteEntityExt.getCelularFamiliar() );
        postulanteDto.setTelefonoFijo( postulanteEntityExt.getTelefonoFijo() );
        postulanteDto.setEmail( postulanteEntityExt.getEmail() );
        postulanteDto.setEmailSecundario( postulanteEntityExt.getEmailSecundario() );
        postulanteDto.setProfesion( postulanteEntityExt.getProfesion() );
        postulanteDto.setLugarEstudios( postulanteEntityExt.getLugarEstudios() );
        postulanteDto.setUltimoCursoRealizado( postulanteEntityExt.getUltimoCursoRealizado() );
        postulanteDto.setEmpresaCurso( postulanteEntityExt.getEmpresaCurso() );
        postulanteDto.setTrabajoReciente( postulanteEntityExt.getTrabajoReciente() );
        postulanteDto.setFechaIngresoTrabajoReciente( postulanteEntityExt.getFechaIngresoTrabajoReciente() );
        postulanteDto.setFechaSalidaTrabajoReciente( postulanteEntityExt.getFechaSalidaTrabajoReciente() );
        postulanteDto.setEmpresaTrabajoReciente( postulanteEntityExt.getEmpresaTrabajoReciente() );
        postulanteDto.setMotivoSalidaTrabajoReciente( postulanteEntityExt.getMotivoSalidaTrabajoReciente() );
        postulanteDto.setDisponibilidadViajar( postulanteEntityExt.getDisponibilidadViajar() );
        postulanteDto.setExperienciaRubro( postulanteEntityExt.getExperienciaRubro() );
        postulanteDto.setEstadoPostulacion( postulanteEntityExt.getEstadoPostulacion() );
        postulanteDto.setFechaPostulacion( postulanteEntityExt.getFechaPostulacion() );
        postulanteDto.setProcedencia( postulanteEntityExt.getProcedencia() );
        postulanteDto.setIdOferta( postulanteEntityExt.getIdOferta() );
        postulanteDto.setOfertaPostulada( postulanteEntityExt.getOfertaPostulada() );
        postulanteDto.setSubEstadoExamen( postulanteEntityExt.getSubEstadoExamen() );
        postulanteDto.setExamenId( postulanteEntityExt.getExamenId() );
        postulanteDto.setCentroMedicoId( postulanteEntityExt.getCentroMedicoId() );
        postulanteDto.setCentroMedicoNombre( postulanteEntityExt.getCentroMedicoNombre() );
        postulanteDto.setFechaRegistroExamen( postulanteEntityExt.getFechaRegistroExamen() );
        postulanteDto.setEncargadoId( postulanteEntityExt.getEncargadoId() );
        postulanteDto.setEncargadoNombre( postulanteEntityExt.getEncargadoNombre() );
        postulanteDto.setFechaProgramadaExamen( postulanteEntityExt.getFechaProgramadaExamen() );
        postulanteDto.setExamenId( postulanteEntityExt.getExamenId());
        postulanteDto.setTipoExamenNombre( postulanteEntityExt.getTipoExamenNombre());
        return postulanteDto;
    }

    @Override
    public PostulanteEntity toPostulanteEntity(PostulanteDto postulanteDto) {
        if ( postulanteDto == null ) {
            return null;
        }

        PostulanteEntity postulanteEntity = new PostulanteEntity();

        postulanteEntity.setId( postulanteDto.getId() );
        postulanteEntity.setPrimerNombre( postulanteDto.getPrimerNombre() );
        postulanteEntity.setSegundoNombre( postulanteDto.getSegundoNombre() );
        postulanteEntity.setApellidoPaterno( postulanteDto.getApellidoPaterno() );
        postulanteEntity.setApellidoMaterno( postulanteDto.getApellidoMaterno() );
        postulanteEntity.setIdEstadoCivil( postulanteDto.getIdEstadoCivil() );
        postulanteEntity.setDni( postulanteDto.getDni() );
        postulanteEntity.setFechaNacimiento( postulanteDto.getFechaNacimiento() );
        postulanteEntity.setDireccion( postulanteDto.getDireccion() );
        postulanteEntity.setIdDistrito( postulanteDto.getIdDistrito() );
        postulanteEntity.setIdProvincia( postulanteDto.getIdProvincia() );
        postulanteEntity.setIdDepartamento( postulanteDto.getIdDepartamento() );
        postulanteEntity.setCelular( postulanteDto.getCelular() );
        postulanteEntity.setCelularFamiliar( postulanteDto.getCelularFamiliar() );
        postulanteEntity.setTelefonoFijo( postulanteDto.getTelefonoFijo() );
        postulanteEntity.setEmail( postulanteDto.getEmail() );
        postulanteEntity.setEmailSecundario( postulanteDto.getEmailSecundario() );
        postulanteEntity.setProfesion( postulanteDto.getProfesion() );
        postulanteEntity.setLugarEstudios( postulanteDto.getLugarEstudios() );
        postulanteEntity.setUltimoCursoRealizado( postulanteDto.getUltimoCursoRealizado() );
        postulanteEntity.setEmpresaCurso( postulanteDto.getEmpresaCurso() );
        postulanteEntity.setTrabajoReciente( postulanteDto.getTrabajoReciente() );
        postulanteEntity.setFechaIngresoTrabajoReciente( postulanteDto.getFechaIngresoTrabajoReciente() );
        postulanteEntity.setFechaSalidaTrabajoReciente( postulanteDto.getFechaSalidaTrabajoReciente() );
        postulanteEntity.setEmpresaTrabajoReciente( postulanteDto.getEmpresaTrabajoReciente() );
        postulanteEntity.setMotivoSalidaTrabajoReciente( postulanteDto.getMotivoSalidaTrabajoReciente() );
        postulanteEntity.setDisponibilidadViajar( postulanteDto.getDisponibilidadViajar() );
        postulanteEntity.setExperienciaRubro( postulanteDto.getExperienciaRubro() );
        postulanteEntity.setEstadoPostulacion( postulanteDto.getEstadoPostulacion() );
        postulanteEntity.setFechaPostulacion( postulanteDto.getFechaPostulacion() );
        postulanteEntity.setProcedencia( postulanteDto.getProcedencia() );
        postulanteEntity.setIdOferta( postulanteDto.getIdOferta() );
        postulanteEntity.setOfertaPostulada( postulanteDto.getOfertaPostulada() );
        postulanteEntity.setEstado( postulanteDto.getEstado() );

        return postulanteEntity;
    }
}
