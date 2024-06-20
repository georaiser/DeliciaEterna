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
@Table(name = "CLIENTE")
public class Cliente {
    @Id
    @Column(name = "rutCliente", length = 15)
    private String rutCliente;

    @Column(name = "nombre", length = 15)
    private String nombre;

    @Column(name = "primerApellido", length = 15)
    private String primerApellido;

    @Column(name = "segundoApellido", length = 15)
    private String segundoApellido;

    @Column(name = "direccion", length = 50)
    private String direccion;

    @Column(name = "comuna", length = 50)
    private String comuna;

    @Column(name = "telefono",  length = 15)
    private String telefono;

    @Column(name = "e-mail",  length = 20)
    private String email;

    @Column(name = "puntos",  length = 11)
    private Integer puntos;

    public Cliente(String rutCliente, String nombre, String primerApellido, String segundoApellido, String direccion, String comuna, String telefono, String email, Integer puntos) {
        this.rutCliente = rutCliente;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.direccion = direccion;
        this.comuna = comuna;
        this.telefono = telefono;
        this.email = email;
        this.puntos = puntos;
    }
}