package com.examenT2.lp2_t2_enriquez_jhonatan.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tbl_proveedor")
public class ProveedorEnriquezJhonatan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer idProveedor;

    private String ruc;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    private String direccion;

    @Column(name = "pagina_web")
    private String paginaWeb;

    @ManyToOne
    @JoinColumn(name = "id_rubro")
    private RubroEnriquezJhonatan rubro;
}
