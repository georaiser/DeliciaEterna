package com.deliciaeterna.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDTO {
    private Integer idSucursal;
    private String nombreSucursal;
    private String nombreCategoria;
    private Integer idProducto;
    private String nombreProducto;
    private Integer stock;
}