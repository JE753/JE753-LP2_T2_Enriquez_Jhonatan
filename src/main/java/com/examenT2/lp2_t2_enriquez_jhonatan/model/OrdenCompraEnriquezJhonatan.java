package com.examenT2.lp2_t2_enriquez_jhonatan.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tbl_orden_compra")
public class OrdenCompraEnriquezJhonatan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_orden")
    private Integer nroOrden;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private ProveedorEnriquezJhonatan proveedor;

    private BigDecimal monto;

    @Column(name = "direccion_entrega")
    private String direccionEntrega;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;

    @Column(name = "estado", length = 1)
    private String estado = "P";
}
