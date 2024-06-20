package com.deliciaeterna.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "CATEGORIA_PRODUCTO")
public class CategoriaProducto {
    @Id
    @Column(name = "idCategoriaProducto", length = 11)
    private Integer idCategoriaProducto;

    @Column(name = "nombre", length = 20)
    private String nombre;

    @Column(name = "descripcion", length=50)
    private String descripcion;

    public CategoriaProducto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}