package com.examenT2.lp2_t2_enriquez_jhonatan.service;

import com.examenT2.lp2_t2_enriquez_jhonatan.dto.ResultadoResponse;
import com.examenT2.lp2_t2_enriquez_jhonatan.model.OrdenCompraEnriquezJhonatan;
import com.examenT2.lp2_t2_enriquez_jhonatan.model.ProveedorEnriquezJhonatan;
import java.util.List;

public interface OrdenCompraServiceEnriquezJhonatan {
    List<OrdenCompraEnriquezJhonatan> listarOrdenes();
    List<ProveedorEnriquezJhonatan> listarProveedores();
    OrdenCompraEnriquezJhonatan buscarPorId(Integer id);
    ResultadoResponse registrar(OrdenCompraEnriquezJhonatan orden);
    ResultadoResponse actualizar(OrdenCompraEnriquezJhonatan orden);
}
