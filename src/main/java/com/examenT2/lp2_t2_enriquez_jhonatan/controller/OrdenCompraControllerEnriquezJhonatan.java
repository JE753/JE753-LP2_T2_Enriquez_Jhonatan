package com.examenT2.lp2_t2_enriquez_jhonatan.controller;

import com.examenT2.lp2_t2_enriquez_jhonatan.dto.ResultadoResponse;
import com.examenT2.lp2_t2_enriquez_jhonatan.model.OrdenCompraEnriquezJhonatan;
import com.examenT2.lp2_t2_enriquez_jhonatan.service.OrdenCompraServiceEnriquezJhonatan;
import com.examenT2.lp2_t2_enriquez_jhonatan.util.Alert;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/orden")
public class OrdenCompraControllerEnriquezJhonatan {

    private final OrdenCompraServiceEnriquezJhonatan service;

    public OrdenCompraControllerEnriquezJhonatan(OrdenCompraServiceEnriquezJhonatan service) {
        this.service = service;
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("ordenes", service.listarOrdenes());
        return "orden/listadoEnriquezJhonatan";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("orden", new OrdenCompraEnriquezJhonatan());
        model.addAttribute("proveedores", service.listarProveedores());
        return "orden/nuevoEnriquezJhonatan";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("orden") OrdenCompraEnriquezJhonatan orden, RedirectAttributes ra) {
        ResultadoResponse resultado = service.registrar(orden);
        ra.addFlashAttribute("alert", crearAlert(resultado));
        return "redirect:/orden/listado";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("orden", service.buscarPorId(id));
        model.addAttribute("proveedores", service.listarProveedores());
        return "orden/edicionEnriquezJhonatan";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute("orden") OrdenCompraEnriquezJhonatan orden, RedirectAttributes ra) {
        ResultadoResponse resultado = service.actualizar(orden);
        ra.addFlashAttribute("alert", crearAlert(resultado));
        return "redirect:/orden/listado";
    }

    private Alert crearAlert(ResultadoResponse resultado) {
        return resultado.isExito() ? Alert.success(resultado.getMensaje()) : Alert.danger(resultado.getMensaje());
    }
}
