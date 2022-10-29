package com.pe.ttk.admision.entity.admision;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@NoArgsConstructor
@Data
public class PostulanteEntityExt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @NotEmpty
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @NotEmpty
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    @NotEmpty
    @Column(name = "id_estado_civil")
    private Long idEstadoCivil;
    @NotEmpty
    private String dni;
    @NotEmpty
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    @NotEmpty
    private String direccion;
    @NotEmpty
    @Column(name = "id_distrito")
    private Long idDistrito;
    private String distritoDescripcion;
    @NotEmpty
    @Column(name = "id_provincia")
    private Long idProvincia;
    private String provinciaDescripcion;
    @NotEmpty
    @Column(name = "id_departamento")
    private Long idDepartamento;
    private String departamentoDescripcion;
    @NotEmpty
    private String celular;
    @Column(name = "celular_familiar")
    private String celularFamiliar;
    @Column(name = "telefono_fijo")
    private String telefonoFijo;
    @NotEmpty
    @Email
    private String email;
    @Column(name = "email_secundario")
    private String emailSecundario;
    private String profesion;
    @Column(name = "lugar_estudios")
    private String lugarEstudios;
    @Column(name = "ultimo_curso_realizado")
    private String ultimoCursoRealizado;
    @Column(name = "empresa_curso")
    private String empresaCurso;
    @Column(name = "trabajo_reciente")
    private String trabajoReciente;
    @Column(name = "fecha_ingreso_trabajo_reciente")
    private Date fechaIngresoTrabajoReciente;
    @Column(name = "fecha_salida_trabajo_reciente")
    private Date fechaSalidaTrabajoReciente;
    @Column(name = "empresa_trabajo_reciente")
    private String empresaTrabajoReciente;
    @Column(name = "motivo_salida_trabajo_reciente")
    private String motivoSalidaTrabajoReciente;
    @Column(name = "disponibilidad_viajar")
    private Integer disponibilidadViajar;
    @Column(name = "experiencia_rubro")
    private Integer experienciaRubro;
    @Column(name = "estado_postulacion")
    private Integer estadoPostulacion;
    @Column(name = "fecha_postulacion")
    private Date fechaPostulacion;
    private String procedencia;
    private Long idOferta;
    @Column(name = "oferta_postulada")
    private String ofertaPostulada;
    private String curriculum;
    @Column(name = "dni_frontal")
    private String dniFrontal;
    @Column(name = "dni_posterior")
    private String dniPosterior;
    private String foto;
    private Integer subEstadoExamen;

    public PostulanteEntityExt(PostulanteEntity postulanteEntity, Integer idEstado) {
        id = postulanteEntity.getId();
        primerNombre = postulanteEntity.getPrimerNombre();
        segundoNombre = postulanteEntity.getSegundoNombre();
        apellidoPaterno=postulanteEntity.getApellidoPaterno();
        apellidoMaterno=postulanteEntity.getApellidoMaterno();
        idEstadoCivil=postulanteEntity.getIdEstadoCivil();
        dni=postulanteEntity.getDni();
        fechaNacimiento=postulanteEntity.getFechaNacimiento();
        direccion=postulanteEntity.getDireccion();
        idDistrito=postulanteEntity.getIdDistrito();
        idProvincia=postulanteEntity.getIdProvincia();
        idDepartamento=postulanteEntity.getIdDepartamento();
        celular=postulanteEntity.getCelular();
        celularFamiliar=postulanteEntity.getCelularFamiliar();
        telefonoFijo=postulanteEntity.getTelefonoFijo();
        email=postulanteEntity.getEmail();
        emailSecundario=postulanteEntity.getEmailSecundario();
        profesion=postulanteEntity.getProfesion();
        lugarEstudios=postulanteEntity.getLugarEstudios();
        ultimoCursoRealizado=postulanteEntity.getUltimoCursoRealizado();
        empresaCurso=postulanteEntity.getEmpresaCurso();
        trabajoReciente=postulanteEntity.getTrabajoReciente();
        fechaIngresoTrabajoReciente=postulanteEntity.getFechaIngresoTrabajoReciente();
        fechaSalidaTrabajoReciente=postulanteEntity.getFechaSalidaTrabajoReciente();
        empresaTrabajoReciente=postulanteEntity.getEmpresaTrabajoReciente();
        motivoSalidaTrabajoReciente=postulanteEntity.getMotivoSalidaTrabajoReciente();
        disponibilidadViajar=postulanteEntity.getDisponibilidadViajar();
        experienciaRubro=postulanteEntity.getExperienciaRubro();
        estadoPostulacion=postulanteEntity.getEstadoPostulacion();
        fechaPostulacion=postulanteEntity.getFechaPostulacion();
        procedencia=postulanteEntity.getProcedencia();
        idOferta=postulanteEntity.getIdOferta();
        ofertaPostulada=postulanteEntity.getOfertaPostulada();
        subEstadoExamen=idEstado;
    }
    public PostulanteEntityExt(PostulanteEntity postulanteEntity, String distrito,String provincia, String departamento) {
        id = postulanteEntity.getId();
        primerNombre = postulanteEntity.getPrimerNombre();
        segundoNombre = postulanteEntity.getSegundoNombre();
        apellidoPaterno=postulanteEntity.getApellidoPaterno();
        apellidoMaterno=postulanteEntity.getApellidoMaterno();
        idEstadoCivil=postulanteEntity.getIdEstadoCivil();
        dni=postulanteEntity.getDni();
        fechaNacimiento=postulanteEntity.getFechaNacimiento();
        direccion=postulanteEntity.getDireccion();
        idDistrito=postulanteEntity.getIdDistrito();
        idProvincia=postulanteEntity.getIdProvincia();
        idDepartamento=postulanteEntity.getIdDepartamento();
        celular=postulanteEntity.getCelular();
        celularFamiliar=postulanteEntity.getCelularFamiliar();
        telefonoFijo=postulanteEntity.getTelefonoFijo();
        email=postulanteEntity.getEmail();
        emailSecundario=postulanteEntity.getEmailSecundario();
        profesion=postulanteEntity.getProfesion();
        lugarEstudios=postulanteEntity.getLugarEstudios();
        ultimoCursoRealizado=postulanteEntity.getUltimoCursoRealizado();
        empresaCurso=postulanteEntity.getEmpresaCurso();
        trabajoReciente=postulanteEntity.getTrabajoReciente();
        fechaIngresoTrabajoReciente=postulanteEntity.getFechaIngresoTrabajoReciente();
        fechaSalidaTrabajoReciente=postulanteEntity.getFechaSalidaTrabajoReciente();
        empresaTrabajoReciente=postulanteEntity.getEmpresaTrabajoReciente();
        motivoSalidaTrabajoReciente=postulanteEntity.getMotivoSalidaTrabajoReciente();
        disponibilidadViajar=postulanteEntity.getDisponibilidadViajar();
        experienciaRubro=postulanteEntity.getExperienciaRubro();
        estadoPostulacion=postulanteEntity.getEstadoPostulacion();
        fechaPostulacion=postulanteEntity.getFechaPostulacion();
        procedencia=postulanteEntity.getProcedencia();
        idOferta=postulanteEntity.getIdOferta();
        ofertaPostulada=postulanteEntity.getOfertaPostulada();
        distritoDescripcion =distrito;
        provinciaDescripcion =provincia;
        departamentoDescripcion=departamento;
    }
}
