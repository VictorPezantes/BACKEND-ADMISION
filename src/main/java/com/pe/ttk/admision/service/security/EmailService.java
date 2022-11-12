package com.pe.ttk.admision.service.security;

import org.springframework.web.multipart.MultipartFile;

public interface EmailService {

    void enviarEmailPostulante(String toEmail, String mensaje, String asunto, String nombre);
    void enviarEmailExamen(String toEmail, String mensaje, String asunto, String nombre);
    void enviarEmail(String toEmail, String mensaje, String asunto, String nombre, byte[] archivo,String nombreArchivo);

}
