package com.pe.ttk.admision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.TimeZone;

@SpringBootApplication
public class TtkAdmisionApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC-5"));
		SpringApplication.run(TtkAdmisionApplication.class, args);
	}



}
