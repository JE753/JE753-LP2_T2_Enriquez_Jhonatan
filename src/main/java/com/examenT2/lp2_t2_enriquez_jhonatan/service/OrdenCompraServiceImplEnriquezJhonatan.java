package com.examenT2.lp2_t2_enriquez_jhonatan.service;

import com.examenT2.lp2_t2_enriquez_jhonatan.dto.ResultadoResponse;
import com.examenT2.lp2_t2_enriquez_jhonatan.model.OrdenCompraEnriquezJhonatan;
import com.examenT2.lp2_t2_enriquez_jhonatan.model.ProveedorEnriquezJhonatan;
import com.examenT2.lp2_t2_enriquez_jhonatan.repository.OrdenCompraRepositoryEnriquezJhonatan;
import com.examenT2.lp2_t2_enriquez_jhonatan.repository.ProveedorRepositoryEnriquezJhonatan;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrdenCompraServiceImplEnriquezJhonatan implements OrdenCompraServiceEnriquezJhonatan {

    private final OrdenCompraRepositoryEnriquezJhonatan ordenRepository;
    private final ProveedorRepositoryEnriquezJhonatan proveedorRepository;

    public OrdenCompraServiceImplEnriquezJhonatan(OrdenCompraRepositoryEnriquezJhonatan ordenRepository,
                                                  ProveedorRepositoryEnriquezJhonatan proveedorRepository) {
        this.ordenRepository = ordenRepository;
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public List<OrdenCompraEnriquezJhonatan> listarOrdenes() {
        return ordenRepository.findAll(Sort.by(Sort.Direction.DESC, "nroOrden"));
    }

    @Override
    public List<ProveedorEnriquezJhonatan> listarProveedores() {
        return proveedorRepository.findAll();
    }

    @Override
    public OrdenCompraEnriquezJhonatan buscarPorId(Integer id) {
        return ordenRepository.findById(id).orElse(null);
    }

    @Override
    public ResultadoResponse registrar(OrdenCompraEnriquezJhonatan orden) {
        try {
            OrdenCompraEnriquezJhonatan guardada = ordenRepository.save(orden);
            return new ResultadoResponse(true, "Orden de compra Nro. " + guardada.getNroOrden() + " registrada.");
        } catch (Exception e) {
            return new ResultadoResponse(false, "No se pudo registrar la orden de compra.");
        }
    }

    @Override
    public ResultadoResponse actualizar(OrdenCompraEnriquezJhonatan orden) {
        try {
            OrdenCompraEnriquezJhonatan guardada = ordenRepository.save(orden);
            return new ResultadoResponse(true, "Orden de compra Nro. " + guardada.getNroOrden() + " actualizada.");
        } catch (Exception e) {
            return new ResultadoResponse(false, "No se pudo actualizar la orden de compra.");
        }
    }
}
