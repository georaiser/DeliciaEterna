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
@Table(name = "ADMINISTRADOR")
public class Administrador {
    @Id
    @Column(name = "idAdministrador", length = 11)
    private Integer idAdministrador;

    @Column(name = "nombre", length = 20)
    private String nombre;

    public Administrador(String nombre) {
        this.nombre = nombre;
    }   
}