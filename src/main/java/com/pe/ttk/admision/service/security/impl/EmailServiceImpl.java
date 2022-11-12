package com.pe.ttk.admision.service.security.impl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import com.pe.ttk.admision.dto.security.EmailValuesDto;
import com.pe.ttk.admision.service.security.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailServiceImpl implements EmailService {

	private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);
	@Autowired
	JavaMailSender javaMailSender;
	
	@Autowired
	TemplateEngine templateEngine;
	
	@Value("${mail.urlFront}")
	private String urlFront;

	@Value("${spring.mail.username}")
	private String fromEmail;
	
	
	public void sendMailTemplate(EmailValuesDto emailValuesDto) {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			Context context = new Context();
			Map<String,Object> model = new HashMap<>();
			model.put("userName", emailValuesDto.getUserName());
			model.put("url", urlFront + emailValuesDto.getToken() );
			context.setVariables(model);
			String htmlText = templateEngine.process("email-template", context);
			helper.setFrom(emailValuesDto.getMailFrom());
			helper.setTo(emailValuesDto.getMailTo());
			helper.setSubject(emailValuesDto.getSubject());
			helper.setText(htmlText,true);
			javaMailSender.send(message);
			
			
		} catch (MessagingException e) {
			logger.error(e.getMessage());
		}
		
	}

	@Override
	public void enviarEmailPostulante(String toEmail, String mensaje, String asunto, String nombre) {

		MimeMessage message = javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			Context context = new Context();
			Map<String,Object> model = new HashMap<>();
			model.put("nombre", nombre);
			model.put("mensaje", mensaje);
			context.setVariables(model);
			String htmlText = templateEngine.process("email-postulante", context);
			helper.setFrom(fromEmail);
			helper.setTo(toEmail);
			helper.setSubject(asunto);
			helper.setText(htmlText,true);
			javaMailSender.send(message);

		} catch (MessagingException e) {
			logger.error(e.getMessage());
		}

	}

	@Override
	public void enviarEmailExamen(String toEmail, String mensaje, String asunto, String nombre) {
		MimeMessage message = javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			Context context = new Context();
			Map<String,Object> model = new HashMap<>();
			model.put("nombre", nombre);
			model.put("mensaje", mensaje);
			context.setVariables(model);
			String htmlText = templateEngine.process("email-examen", context);
			helper.setFrom(fromEmail);
			helper.setTo(toEmail);
			helper.setSubject(asunto);
			helper.setText(htmlText,true);
			javaMailSender.send(message);

		} catch (MessagingException e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void enviarEmail(String toEmail, String mensaje, String asunto, String nombre, byte[] archivo,String nombreArchivo) {
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			Context context = new Context();
			Map<String,Object> model = new HashMap<>();
			model.put("nombre", nombre);
			model.put("mensaje", mensaje);
			context.setVariables(model);
			String htmlText = templateEngine.process("email-examen", context);
			helper.setFrom(fromEmail);
			helper.setTo(toEmail);
			helper.setSubject(asunto);
			helper.setText(htmlText,true);
			helper.addAttachment(nombreArchivo, new ByteArrayResource(archivo));
			javaMailSender.send(message);

		} catch (MessagingException e) {
			logger.error(e.getMessage());
		}
	}


}
