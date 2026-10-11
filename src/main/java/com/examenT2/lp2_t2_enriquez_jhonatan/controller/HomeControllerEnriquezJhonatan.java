package com.examenT2.lp2_t2_enriquez_jhonatan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControllerEnriquezJhonatan {

    @GetMapping("/")
    public String inicio() {
        return "redirect:/orden/listado";
    }
}
