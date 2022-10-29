package com.pe.ttk.admision.service.security;

public interface EmailService {

    void enviarEmailPostulante(String toEmail, String mensaje, String asunto, String nombre);
    void enviarEmailExamen(String toEmail, String mensaje, String asunto, String nombre);

}
