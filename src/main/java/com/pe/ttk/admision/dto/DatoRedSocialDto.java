package com.pe.ttk.admision.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DatoRedSocialDto {
    private Long id;
    private String nombre;
    private String link;
    private Long postulanteId;
}
