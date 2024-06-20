package com.deliciaeterna.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "PRODUCTO")
public class Producto {
    @Id
    @Column(name = "idProducto", length = 11)
    private Integer idProducto;

    @Column(name = "nombreProducto", length = 30)
    private String nombreProducto;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "precio", length = 11)
    private Integer precio;

    @ManyToOne
    @JoinColumn(name = "FK_idCategoriaProducto")
    private CategoriaProducto categoriaProducto;

    public Producto(String nombreProducto, String descripcion, Integer precio, CategoriaProducto categoriaProducto) {
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoriaProducto = categoriaProducto;
    }
}