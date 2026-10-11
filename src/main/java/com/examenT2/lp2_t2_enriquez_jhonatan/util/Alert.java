package com.examenT2.lp2_t2_enriquez_jhonatan.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Alert {
    private String tipo;
    private String mensaje;

    public static Alert success(String mensaje) {
        return new Alert("success", mensaje);
    }

    public static Alert danger(String mensaje) {
        return new Alert("danger", mensaje);
    }
}
