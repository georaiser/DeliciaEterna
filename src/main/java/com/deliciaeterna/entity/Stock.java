package com.deliciaeterna.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "stock")
@IdClass(StockId.class)
public class Stock {
    @Id
    @Column(name = "idProducto")
    private Integer idProducto;

    @Id
    @Column(name = "idSucursal")
    private Integer idSucursal;

    @Column(name = "stock")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "FK_idAdministrador")
    private Administrador administrador;
    
    // JOINS
    
    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", insertable = false, updatable = false)
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name = "idSucursal", referencedColumnName = "idSucursal", insertable = false, updatable = false)
    private Sucursal sucursal;

    public Stock(Integer idProducto, Integer idSucursal, Integer stock, Administrador administrador) {
        this.idProducto = idProducto;
        this.idSucursal = idSucursal;
        this.stock = stock;
        this.administrador = administrador;
    }
      
    
}