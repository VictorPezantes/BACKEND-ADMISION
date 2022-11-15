package com.pe.ttk.admision.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pe.ttk.admision.util.Constantes;
import lombok.*;

import javax.validation.constraints.Email;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class PostulanteDto {

    private Long id;
    private String primerNombre;
    private String segundoNombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Long idEstadoCivil;
    private String dni;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Lima")
    private Date fechaNacimiento;
    private String direccion;
    private Long idDistrito;
    private String DistritoDescripcion;
    private Long idProvincia;
    private String ProvinciaDescripcion;
    private Long idDepartamento;
    private String DepartamentoDescripcion;
    private String celular;
    private String celularFamiliar;
    private String telefonoFijo;
    @Email
    private String email;
    private String emailSecundario;
    private String profesion;
    private String lugarEstudios;
    private String ultimoCursoRealizado;
    private String empresaCurso;
    private String trabajoReciente;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Lima")
    private Date fechaIngresoTrabajoReciente;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Lima")
    private Date fechaSalidaTrabajoReciente;
    private String empresaTrabajoReciente;
    private String motivoSalidaTrabajoReciente;
    private Integer disponibilidadViajar;
    private Integer experienciaRubro;
    private Integer estadoPostulacion;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Lima")
    private Date fechaPostulacion;
    private String procedencia;
    private Long idOferta;
    private String ofertaPostulada;
    private String urlCurriculumVitae;
    private String urlDniFrontal;
    private String urlDniPosterior;
    private String urlFotografia;
    private Integer estadoPostulanteId;
    private String estadoPostulanteNombre;
    private Integer subEstadoExamen;
    private Long examenId;
    private int centroMedicoId;
    private String centroMedicoNombre;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Lima")
    private Date fechaRegistroExamen;
    private Long encargadoId;
    private String encargadoNombre;
    private String encargadoEmail;
    private String encargadoTelefono;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Lima")
    private Date fechaProgramadaExamen;
    private Integer tipoExamenId;
    private String tipoExamenNombre;
    private String sexo;
    private String nacionalidad;
    private Boolean sabeNadar;
    private Date fechaMatrimonio;
    private String lugarNacimiento;
    private String grupoSanguineo;
    private String examenObservacion;
    public List<String> Validar()
    {
        List<String> validaciones = new ArrayList<String>();

        Date fechaActual = new Date(System.currentTimeMillis());
        long diff = fechaActual.getTime() - fechaNacimiento.getTime();
        if (diff < 0) {
            validaciones.add("Error en fecha");
        }

        Instant instant = fechaNacimiento.toInstant();
        ZonedDateTime zdt = instant.atZone(ZoneOffset.UTC);
        LocalDate fechaNac = zdt.toLocalDate();
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);
        if(idOferta == null) {
            validaciones.add("Error en ofertaPostulada");
        }
        if(periodo.getYears() < Constantes.EDAD_OPERARIO && Constantes.CARGO_OPERARIO.equalsIgnoreCase(ofertaPostulada)) {
            validaciones.add("No cumple requisito de edad (31)");
        }
        if(periodo.getYears() >= Constantes.EDAD_TECNICO_SUPERVISOR && (Constantes.CARGO_TECNICO.equalsIgnoreCase(ofertaPostulada) || Constantes.CARGO_SUPERVISOR.equalsIgnoreCase(ofertaPostulada))) {
            validaciones.add("No cumple requisito de edad < 65");
        }
        if(celular != null && celular.length() <= Constantes.LONGITUD_CELULAR_MINIMA) {
            validaciones.add("Cantidad de dígitos tiene que ser mayor a "+Constantes.LONGITUD_CELULAR_MINIMA);
        }
        return validaciones;
    }
}
