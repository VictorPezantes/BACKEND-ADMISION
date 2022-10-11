package com.pe.ttk.admision.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mensaje {
    private String mensaje;
    private boolean exito;
}
