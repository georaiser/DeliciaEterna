package com.deliciaeterna.entity;

import java.time.LocalDate;

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
@Table(name = "VENTA")
public class Venta {
    @Id
    @Column(name = "idVenta", length = 11)
    private Integer idVenta;

    @ManyToOne
    @JoinColumn(name = "FK_idSucursal")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "FK_rutCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "FK_idAdministrador")
    private Administrador administrador;

    @Column(name = "fecha")
    private LocalDate fecha;

    public Venta(Sucursal sucursal, Cliente cliente, Administrador administrador, LocalDate fecha) {
        this.sucursal = sucursal;
        this.cliente = cliente;
        this.administrador = administrador;
        this.fecha = fecha;
    }
}