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
@Table(name = "COLABORADOR")
public class Colaborador {
    @Id
    @Column(name = "rutColaborador", length = 15)
    private String rutColaborador;

    @Column(name = "nombre", length = 15)
    private String nombre;

    @Column(name = "primerApellido", length = 15)
    private String primerApellido;

    @Column(name = "segundoApellido", length = 15)
    private String segundoApellido;

    @Column(name = "direccion", length = 50)
    private String direccion;

    @Column(name = "comuna", length = 30)
    private String comuna;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "rol", length = 11)
    private Integer rol;

    @ManyToOne
    @JoinColumn(name = "FK_idSucursal")
    private Sucursal sucursal;

    public Colaborador(String rutColaborador, String nombre, String primerApellido, String segundoApellido, String direccion, String comuna, String telefono, Integer rol, Sucursal sucursal) {
        this.rutColaborador = rutColaborador;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.direccion = direccion;
        this.comuna = comuna;
        this.telefono = telefono;
        this.rol = rol;
        this.sucursal = sucursal;
    }
}