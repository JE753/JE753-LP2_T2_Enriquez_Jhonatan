package com.examenT2.lp2_t2_enriquez_jhonatan.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_rubro")
public class RubroEnriquezJhonatan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rubro")
    private Integer idRubro;

    private String denominacion;
}
