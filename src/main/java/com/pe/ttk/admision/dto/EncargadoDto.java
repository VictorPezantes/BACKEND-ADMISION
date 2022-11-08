package com.pe.ttk.admision.dto;

import lombok.Data;

import java.util.List;

@Data
public class EncargadoDto {
    private Long encargadoId;
    private List<Long> postulantes;
}
