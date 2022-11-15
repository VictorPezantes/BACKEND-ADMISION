package com.pe.ttk.admision.service.impl;

import com.pe.ttk.admision.dto.Mensaje;
import com.pe.ttk.admision.dto.MensajeData;
import com.pe.ttk.admision.dto.PostulanteDto;
import com.pe.ttk.admision.entity.admision.ExamenEntity;
import com.pe.ttk.admision.entity.admision.OfertaEntity;
import com.pe.ttk.admision.entity.admision.PostulanteEntity;
import com.pe.ttk.admision.entity.admision.PostulanteEntityExt;
import com.pe.ttk.admision.entity.master.EstadoPostulante;
import com.pe.ttk.admision.entity.master.HistorialEntity;
import com.pe.ttk.admision.entity.master.SubEstado;
import com.pe.ttk.admision.enums.EstadoPostulanteNombre;
import com.pe.ttk.admision.enums.SubEstadoNombre;
import com.pe.ttk.admision.repository.*;
import com.pe.ttk.admision.service.ArchivoService;
import com.pe.ttk.admision.service.ExamenService;
import com.pe.ttk.admision.service.security.EmailService;
import com.pe.ttk.admision.service.PostulanteService;
import com.pe.ttk.admision.util.Constantes;
import com.pe.ttk.admision.util.ConvertirFechas;
import com.pe.ttk.admision.util.mapper.impl.PostulanteMapperImpl;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostulanteServiceImpl implements PostulanteService {

    @Autowired
    private PostulanteRepository postulanteRepository;

    @Autowired
    private OfertaRepository ofertaRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private HistorialRepository historialRepository;

    @Autowired
    ArchivoService archivoService;

    @Autowired
    ExamenRepository examenRepository;

    @Autowired
    SubEstadoRepository subEstadoRepository;


    private Date fechaNacimiento;
    private Date fechaIngresoTrabajoReciente;
    private Date fechaSalidaTrabajoreciente;
    ConvertirFechas convertirFechas = new ConvertirFechas();

    @Autowired
    EstadoPostulanteRepository estadoPostulanteRepository;
    public List<PostulanteEntity> list() {
        return postulanteRepository.findAll();
    }

    @Override
    public List<PostulanteDto> findByQueryString(String estadoPostulacion, String distrito, String provincia, String departamento, String profesion,
                                                        String responsableAsignado, String procedencia, String apellidoPaterno) {
        PostulanteDto postulanteDto = new PostulanteDto();
        List<PostulanteDto> listaPostulantesDto = new ArrayList<>();
        /*List<PostulanteMapping> listaPostulantesMapping = postulanteRepository.findByQueryString(estadoPostulacion,distrito, provincia,departamento);
        if(!listaPostulantesMapping.isEmpty()){for (PostulanteMapping p:listaPostulantesMapping) {
              // postulanteDto.setFechaIngresoTrabajoReciente(p.getFechaIngresoTrabajoReciente());
              // postulanteDto.setFechaSalidaTrabajoreciente(p.getFechaSalidaTrabajoreciente());
               postulanteDto.setApellidoMaterno(p.getApellidoMaterno());
               postulanteDto.setApellidoPaterno(p.getApellidoPaterno());
               postulanteDto.setCelularFamiliar(p.getCelularFamiliar());
               postulanteDto.setCelularPrincipal(p.getCelularPrincipal());
               postulanteDto.setDepartamento(p.getDepartamento());
               postulanteDto.setCurriculumVitae(p.getCurriculumVitae());
               postulanteDto.setDistrito(p.getDistrito());
               postulanteDto.setProvincia(p.getProvincia());
               postulanteDto.setDniFrontal(p.getDniFrontal());
               postulanteDto.setDniPosterior(p.getDniPosterior());
               postulanteDto.setEmailPrincipal(p.getEmailPrincipal());
               postulanteDto.setEmailSecundario(p.getEmailSecundario());
               postulanteDto.setEmpresaCurso(p.getEmpresaCurso());
               postulanteDto.setDireccionPrincipal(p.getDireccionPrincipal());
               postulanteDto.setEmpresaTrabajoReciente(p.getEmpresaTrabajoReciente());
               postulanteDto.setEstadoCivil(p.getEstadoCivil());
               postulanteDto.setEstadoPostulacion(p.getEstadoPostulacion());
               postulanteDto.setFotografia(p.getFotografia());
               postulanteDto.setTelefonoFijo(p.getTelefonoFijo());
               postulanteDto.setRespuestaDisponibilidadViajar(p.getRespuestaDisponibilidadViajar());
               postulanteDto.setRespuestaExperienciaMantencion(p.getRespuestaExperienciaMantencion());
               //postulanteDto.setFechaNacimiento(p.getFechaNacimiento());
               postulanteDto.setPrimerNombre(p.getPrimerNombre());
               postulanteDto.setSegundoNombre(p.getSegundoNombre());
               postulanteDto.setSubEstadoPostulacion(p.getSubEstadoPostulacion());
               postulanteDto.setUltimoCursoRealizado(p.getUltimoCursoRealizado());
               postulanteDto.setTrabajoReciente(p.getTrabajoReciente());
               postulanteDto.setLugarEstudios(p.getLugarEstudios());
               postulanteDto.setProfesion(p.getProfesion());
               postulanteDto.setResponsableAsignado(p.getResponsableAsignado());
               postulanteDto.setOfertaPostulada(p.getOfertaPostulada());
               postulanteDto.setProcedencia(p.getProcedencia());
               postulanteDto.setCargoPostulante(p.getCargoPostulante());
               postulanteDto.setMotivoSalidaTrabajoReciente(p.getMotivoSalidaTrabajoReciente());
               postulanteDto.setDni(p.getDni());


               listaPostulantesDto.add(postulanteDto);

       }else {
           return listaPostulantesDto;
       }
       */
        return listaPostulantesDto;
    }

    @Override
    public PostulanteDto findByDni(String dni) {
        PostulanteEntity postulante = postulanteRepository.findByDni(dni);
        PostulanteDto postulanteDto = new PostulanteDto();
        postulanteDto.setUrlFotografia(postulante.getFoto());//avatar?
        postulanteDto.setApellidoPaterno(postulante.getApellidoPaterno());
        postulanteDto.setApellidoMaterno(postulante.getApellidoMaterno());
        postulanteDto.setPrimerNombre(postulante.getPrimerNombre());
        postulanteDto.setSegundoNombre(postulante.getSegundoNombre());
        postulanteDto.setEmail(postulante.getEmail());
        postulanteDto.setEmailSecundario(postulante.getEmailSecundario());//empresa?
        postulanteDto.setTelefonoFijo(postulante.getTelefonoFijo());
        postulanteDto.setCelular(postulante.getCelular());
        //postulanteDto.setCelularFamiliar(postulante.getCelularFamiliar());
        //postulanteDto.setEstadoPostulacion(postulante.getEstadoPostulacion());
        return null;
    }


    public Mensaje registrarPostulante(PostulanteDto postulanteDto, MultipartFile curriculum, MultipartFile dniFrontal,
                                       MultipartFile dniPosterior, MultipartFile foto) {

        String dni = postulanteDto.getDni();

        if(postulanteRepository.existsByDniAndActivo(dni,true)){
            return new Mensaje("Ya existe una postulación, solo puede postular una sola vez",false);
        }

        String nombreCurriculum = "";
        String nombreDniFrontal = "";
        String nombreDniPosterior = "";
        String nombreFoto = "";
        if(curriculum != null){
            if(!curriculum.isEmpty()){
                nombreCurriculum = dni+Constantes.CURRICULUM+"."+FilenameUtils.getExtension(curriculum.getOriginalFilename());
                archivoService.guardarArchivo(curriculum, nombreCurriculum);
            }
        }
        if(dniFrontal != null){
            if(!dniFrontal.isEmpty()){
                nombreDniFrontal = dni+Constantes.DNI_FRONTAL+"."+FilenameUtils.getExtension(dniFrontal.getOriginalFilename());
                archivoService.guardarArchivo(dniFrontal, nombreDniFrontal);
            }
        }
        if(dniPosterior != null){
            if(!dniPosterior.isEmpty()){
                nombreDniPosterior = dni+Constantes.DNI_POSTERIOR+"."+FilenameUtils.getExtension(dniPosterior.getOriginalFilename());
                archivoService.guardarArchivo(dniPosterior, nombreDniPosterior);
            }
        }
        if(foto != null){
            if(!foto.isEmpty()){
                nombreFoto = dni+Constantes.FOTO+"."+FilenameUtils.getExtension(foto.getOriginalFilename());
                archivoService.guardarArchivo(foto, nombreFoto);
            }
        }

        PostulanteEntity postulanteEntity = PostulanteMapperImpl.INSTANCE.toPostulanteEntity(postulanteDto);
        postulanteEntity.setFechaPostulacion(ConvertirFechas.getInstance().obtenerFecha(new java.util.Date()));
        postulanteEntity.setCurriculum(nombreCurriculum);
        postulanteEntity.setDniFrontal(nombreDniFrontal);
        postulanteEntity.setDniPosterior(nombreDniPosterior);
        postulanteEntity.setFoto(nombreFoto);

        Optional<OfertaEntity> ofertaOp = ofertaRepository.findByIdAndEstado(postulanteDto.getIdOferta(), Constantes.ESTADO_ACTIVO);
        if(ofertaOp.isEmpty()){
            return new Mensaje("No existe la oferta",false);
        }
        OfertaEntity ofertaDb = ofertaOp.get();
        ofertaDb.setCantidadPostulantes(ofertaDb.getCantidadPostulantes() + 1);
        postulanteEntity.setOferta(ofertaDb);

        int anioActual = ConvertirFechas.getInstance().obtenerAnioMesDia(Calendar.YEAR);
        int mesActual = ConvertirFechas.getInstance().obtenerAnioMesDia(Calendar.MONTH);
        int diaActual = ConvertirFechas.getInstance().obtenerAnioMesDia(Calendar.DAY_OF_MONTH);

        int anioNac = ConvertirFechas.getInstance().obtenerAnioMesDia(Calendar.YEAR, postulanteEntity.getFechaNacimiento());
        int mesNac = ConvertirFechas.getInstance().obtenerAnioMesDia(Calendar.MONTH,postulanteEntity.getFechaNacimiento());
        int diaNac = ConvertirFechas.getInstance().obtenerAnioMesDia(Calendar.DAY_OF_MONTH,postulanteEntity.getFechaNacimiento());

        String mensaje = "";
        String asunto = "Postulación a " + ofertaDb.getTitulo() + " - Technotankers";
        boolean verificarEdad = false;
        int edad = anioActual - anioNac;
        if(ofertaDb.getCargoOferta().getNombreCargo().equalsIgnoreCase(Constantes.CARGO_TECNICO) ||
            ofertaDb.getCargoOferta().getNombreCargo().equalsIgnoreCase(Constantes.CARGO_SUPERVISOR)){
            postulanteEntity.setProcedencia(Constantes.PROC_MILITAR);
            if(anioActual - anioNac == Constantes.EDAD_TECNICO_SUPERVISOR){
                if(mesActual == mesNac && diaActual >= diaNac) verificarEdad = true;
                if(mesActual > mesNac) verificarEdad = true;
                edad = Constantes.EDAD_TECNICO_SUPERVISOR;
            }
            if(anioActual - anioNac < Constantes.EDAD_TECNICO_SUPERVISOR ||
                    anioActual - anioNac > Constantes.EDAD_TECNICO_SUPERVISOR) verificarEdad = false;
        }
        else if(ofertaDb.getCargoOferta().getNombreCargo().equalsIgnoreCase(Constantes.CARGO_OPERARIO)){
            postulanteEntity.setProcedencia(Constantes.PROC_CIVIL);
            if(anioActual - anioNac == Constantes.EDAD_OPERARIO){
                if(mesActual == mesNac && diaActual >= diaNac) verificarEdad = true;
                if(mesActual > mesNac) verificarEdad = true;
                edad = Constantes.EDAD_OPERARIO;
            }
            if(anioActual - anioNac < Constantes.EDAD_OPERARIO || anioActual - anioNac > Constantes.EDAD_OPERARIO) verificarEdad = false;
        }
        if(verificarEdad){
            mensaje = Constantes.MENSAJE_CUMPLE_EDAD;
        }else{
            mensaje = Constantes.MENSAJE_NO_CUMPLE_EDAD;
        }

        Optional<EstadoPostulante> estadoPostulante = estadoPostulanteRepository.findById(EstadoPostulanteNombre.INGRESADO.getValue());
        postulanteEntity.setEstadoPostulante(estadoPostulante.get());

        ofertaRepository.save(ofertaDb);
        postulanteEntity.setActivo(true);
        postulanteEntity = postulanteRepository.save(postulanteEntity);
        registrarHistorial(postulanteEntity, edad, mensaje);

        emailService.enviarEmailPostulante(postulanteDto.getEmail(), mensaje, asunto, postulanteDto.getPrimerNombre());
        return new Mensaje("Postulante registrado correctamente",true);
    }

    @Override
    public Mensaje UpdatePostulante(PostulanteDto postulanteDto, MultipartFile dnifrontal, MultipartFile dniposterior, MultipartFile foto,MultipartFile curriculum) {

        PostulanteEntity postulanteEntity = postulanteRepository.getOne(postulanteDto.getId());
        if(postulanteEntity == null){
            return new Mensaje("No se encontró postulante",false);
        }
        archivoService.actualizarArchivo(dnifrontal, dniposterior, foto);
        if(postulanteDto.getApellidoPaterno() != null){
            postulanteEntity.setApellidoPaterno(postulanteDto.getApellidoPaterno());
        }
        if(postulanteDto.getApellidoMaterno() != null){
            postulanteEntity.setApellidoMaterno(postulanteDto.getApellidoMaterno());
        }
        if(postulanteDto.getCelularFamiliar() != null){
            postulanteEntity.setCelularFamiliar(postulanteDto.getCelularFamiliar());
        }
        if(postulanteDto.getCelular() != null){
            postulanteEntity.setCelular(postulanteDto.getCelular());
        }
        if(postulanteDto.getIdDepartamento() != null){
            postulanteEntity.setIdDepartamento(postulanteDto.getIdDepartamento());
        }
        if(postulanteDto.getIdDistrito() != null){
            postulanteEntity.setIdDistrito(postulanteDto.getIdDistrito());
        }
        if(postulanteDto.getIdProvincia() != null){
            postulanteEntity.setIdProvincia(postulanteDto.getIdProvincia());
        }
        if(dnifrontal != null){
            if(!dnifrontal.isEmpty()){
                postulanteEntity.setDniFrontal(dnifrontal.getOriginalFilename());
            }
        }
        if(dniposterior != null){
            if(!dniposterior.isEmpty()){
                postulanteEntity.setDniPosterior(dniposterior.getOriginalFilename());
            }
        }
        if(foto != null){
            if(!foto.isEmpty()){
                postulanteEntity.setFoto(foto.getOriginalFilename());
            }
        }

        if(curriculum != null){
            if(!curriculum.isEmpty()){
                String nombre = postulanteEntity.getDni()+Constantes.CURRICULUM+"."+FilenameUtils.getExtension(curriculum.getOriginalFilename());
                archivoService.guardarArchivo(curriculum, nombre);
                postulanteEntity.setCurriculum(nombre);
            }
        }
        if(postulanteDto.getDireccion() != null){
            postulanteEntity.setDireccion(postulanteDto.getDireccion());
        }
        if(postulanteDto.getDisponibilidadViajar() != null){
            postulanteEntity.setDisponibilidadViajar(postulanteDto.getDisponibilidadViajar());
        }
        if(postulanteDto.getEmail() != null){
            postulanteEntity.setEmail(postulanteDto.getEmail());
        }
        if(postulanteDto.getEmailSecundario() != null){
            postulanteEntity.setEmailSecundario(postulanteDto.getEmailSecundario());
        }
        if(postulanteDto.getEmpresaCurso() != null){
            postulanteEntity.setEmpresaCurso(postulanteDto.getEmpresaCurso());
        }
        if(postulanteDto.getEmpresaTrabajoReciente() != null){
            postulanteEntity.setEmpresaTrabajoReciente(postulanteDto.getEmpresaTrabajoReciente());
        }
        if(postulanteDto.getExperienciaRubro() != null){
            postulanteEntity.setExperienciaRubro(postulanteDto.getExperienciaRubro());
        }
        if(postulanteDto.getFechaIngresoTrabajoReciente() != null){
            postulanteEntity.setFechaIngresoTrabajoReciente(postulanteDto.getFechaIngresoTrabajoReciente());
        }
        if(postulanteDto.getFechaNacimiento() != null){
            postulanteEntity.setFechaNacimiento(postulanteDto.getFechaNacimiento());
        }
        if(postulanteDto.getFechaPostulacion() != null){
            postulanteEntity.setFechaPostulacion(postulanteDto.getFechaPostulacion());
        }
        if(postulanteDto.getFechaSalidaTrabajoReciente() != null){
            postulanteEntity.setFechaSalidaTrabajoReciente(postulanteDto.getFechaSalidaTrabajoReciente());
        }
        if(postulanteDto.getIdOferta() != null){
            Optional<OfertaEntity> ofertaOp = ofertaRepository.findById(postulanteDto.getIdOferta());
            if(ofertaOp.isPresent()){
                postulanteEntity.setOferta(ofertaOp.get());
            }
        }
        if(postulanteDto.getEstadoPostulanteId() != null){
            Optional<EstadoPostulante> estadoPostulante = estadoPostulanteRepository.findById(postulanteDto.getEstadoPostulanteId());
            if(estadoPostulante.isPresent()){
                postulanteEntity.setEstadoPostulante(estadoPostulante.get());
                if(estadoPostulante.get().getEstadoPostulanteNombre() == EstadoPostulanteNombre.FUERA_DEL_PROCESO){
                    ExamenEntity examenEntity = examenRepository.findByPostulante_Id(postulanteDto.getId());
                    if(examenEntity != null){
                        if(examenEntity.getSubEstado() != null){
                            Optional<SubEstado> subEstado = subEstadoRepository.findById(SubEstadoNombre.CANCELADO.getValue());
                            if(subEstado.isPresent()){
                                examenEntity.setSubEstado(subEstado.get());
                                postulanteEntity.setSubEstado(subEstado.get());
                            }
                        }
                    }
                }
            }
        }
        if(postulanteDto.getSexo() != null){
            postulanteEntity.setSexo(postulanteDto.getSexo());
        }
        if(postulanteDto.getNacionalidad() != null){
            postulanteEntity.setNacionalidad(postulanteDto.getNacionalidad());
        }
        if(postulanteDto.getGrupoSanguineo() != null){
            postulanteEntity.setGrupoSanguineo(postulanteDto.getGrupoSanguineo());
        }
        if(postulanteDto.getSabeNadar() != null){
            postulanteEntity.setSabeNadar(postulanteDto.getSabeNadar());
        }
        if(postulanteDto.getFechaMatrimonio() != null){
            postulanteEntity.setFechaMatrimonio(postulanteDto.getFechaMatrimonio());
        }
        if(postulanteDto.getLugarNacimiento() != null){
            postulanteEntity.setLugarNacimiento(postulanteDto.getLugarNacimiento());
        }
        return new Mensaje("datos de postulante actualizados",true);
    }

    public void delete(int id) {
        postulanteRepository.deleteById((long)id);
    }

    public Optional<PostulanteEntity> getOne(int id) {
        return postulanteRepository.findById((long)id);
    }

    @Override
    public Page<PostulanteDto> listarPostulantes(Integer numPagina, Integer tamPagina) {
        Pageable pageable = PageRequest.of(numPagina, tamPagina);
        List<PostulanteEntityExt> lista = postulanteRepository.findByEstado(null, pageable);
        List<PostulanteDto> listaPostulante = lista.stream().map(PostulanteMapperImpl.INSTANCE::toPostulanteFromExtityExt).collect(Collectors.toList());
        if(!listaPostulante.isEmpty()){
            return new PageImpl<>(listaPostulante, pageable, lista.size());
        }

        return null;
    }

    @Override
    public Page<PostulanteDto> listarPostulanteFiltro(Integer numPagina, Integer tamPagina, Integer estadoPostulanteId, Integer subEstadoExamen, Date fechaInformeMedico, Date fechaProgramada, String filtro, Long encargadoId,Long cargoId, Long postulanteId) {
        Pageable pageable = PageRequest.of(numPagina, tamPagina);
        try{
            List<PostulanteEntityExt> lista = postulanteRepository.findPostulanteFiltro(subEstadoExamen,fechaInformeMedico,fechaProgramada,filtro,estadoPostulanteId,encargadoId,cargoId,postulanteId, pageable);
            List<PostulanteDto> listaPostulante = lista.stream().map(PostulanteMapperImpl.INSTANCE::toPostulanteFromExtityExt).collect(Collectors.toList());
            if(!lista.isEmpty()){
                return new PageImpl<>(listaPostulante, pageable, lista.size());
            }
        }catch(Exception ex){
            System.out.println(ex);
        }

        return null;
    }

    @Override
    public MensajeData<String> obtenerCurriculumPostulanteBase64(Long postulanteId) {
        MensajeData<String> data = new MensajeData<>();
        try {
            Optional<PostulanteEntity> postulanteEntity = postulanteRepository.findById(postulanteId);
            if(postulanteEntity.isEmpty()) {
                data.setExito(false);
                data.setMensaje("Postulante no existe");
                return data;
            }
            data = archivoService.obtenerArchivoBase64("archivos/Postulante/",postulanteEntity.get().getFoto());
        }catch (Exception e) {
            data.setExito(false);
            data.setMensaje("Error: " + e.getMessage());
        }

        return data;
    }

    @Override
    public MensajeData<byte[]> obtenerCurriculumPostulanteByte(Long postulanteId) {
        MensajeData<byte[]> data = new MensajeData<>();
        try {
            Optional<PostulanteEntity> postulanteEntity = postulanteRepository.findById(postulanteId);
            if(postulanteEntity.isEmpty()) {
                data.setExito(false);
                data.setMensaje("Postulante no existe");
                return data;
            }
            data = archivoService.obtenerArchivoByteArray("archivos/Postulante/",postulanteEntity.get().getCurriculum());
        }catch (Exception e) {
            data.setExito(false);
            data.setMensaje("Error: " + e.getMessage());
        }

        return data;
    }


    @Override
    public MensajeData<String> obtenerFotoPostulanteBase64(Long postulanteId) {
        MensajeData<String> data = new MensajeData<>();
        try {
            Optional<PostulanteEntity> postulanteEntity = postulanteRepository.findById(postulanteId);
            if(postulanteEntity.isEmpty()) {
                data.setExito(false);
                data.setMensaje("Postulante no existe");
                return data;
            }
            data = archivoService.obtenerArchivoBase64("archivos/Postulante/",postulanteEntity.get().getFoto());
        }catch (Exception e) {
            data.setExito(false);
            data.setMensaje("Error: " + e.getMessage());
        }

        return data;
    }

    @Override
    public Mensaje enviarCVPorCorreo(Long postulanteId, List<String> correos) {
        Optional<PostulanteEntity> postulanteEntity = postulanteRepository.findById(postulanteId);
        MensajeData<byte[]> curriculum = archivoService.obtenerArchivoByteArray("archivos/Postulante/",postulanteEntity.get().getCurriculum());
        for (String correo : correos){
            emailService.enviarEmail(correo,"Adjuntamos el CV","CV",postulanteEntity.get().getPrimerNombre(),curriculum.getData(),postulanteEntity.get().getCurriculum());
        }
        return null;
    }

    private void registrarHistorial(PostulanteEntity postulanteEntity, Integer edad, String mensaje){
        HistorialEntity historialEntity = new HistorialEntity();
        historialEntity.setIdPostulante(postulanteEntity.getId());
        historialEntity.setPrimerNombre(postulanteEntity.getPrimerNombre());
        historialEntity.setSegundoNombre(postulanteEntity.getSegundoNombre());
        historialEntity.setApellidoPaterno(postulanteEntity.getApellidoPaterno());
        historialEntity.setApellidoMaterno(postulanteEntity.getApellidoMaterno());
        historialEntity.setFechaCambioEstado(ConvertirFechas.getInstance().obtenerFecha(new java.util.Date()));
        historialEntity.setEstadoPostulante(postulanteEntity.getEstadoPostulante());
        historialEntity.setCantidadPostulaciones(1);
        historialEntity.setMensajeEnviado(mensaje);
        historialEntity.setEdadPostulante(edad);
        historialRepository.save(historialEntity);
    }

}
