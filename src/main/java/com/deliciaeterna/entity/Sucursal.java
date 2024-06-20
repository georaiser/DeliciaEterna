package com.deliciaeterna.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "SUCURSAL")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSucursal", length = 11)
    private Integer idSucursal;

    @Column(name = "nombre", length = 20)
    private String nombre;

    @Column(name = "direccion", length = 35)
    private String direccion;

    @Column(name = "comuna", length = 30)
    private String comuna;

    @Column(name = "telefono", length = 15)
    private String telefono;
    
    @OneToMany(mappedBy = "sucursal")
    private List<Stock> stocks;

    public Sucursal(String nombre, String direccion, String comuna, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.comuna = comuna;
        this.telefono = telefono;
    }
}