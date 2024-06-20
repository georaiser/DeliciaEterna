package com.deliciaeterna.entity;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Embeddable
@Data
@NoArgsConstructor
public class StockId implements Serializable {
    @Column(name = "idProducto")
    private Integer idProducto;

    @Column(name = "idSucursal")
    private Integer idSucursal;

    public StockId(Integer idProducto, Integer idSucursal) {
        this.idProducto = idProducto;
        this.idSucursal = idSucursal;
    }
}