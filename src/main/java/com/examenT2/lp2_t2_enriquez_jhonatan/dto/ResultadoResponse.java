package com.examenT2.lp2_t2_enriquez_jhonatan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultadoResponse {
    private boolean exito;
    private String mensaje;
}
