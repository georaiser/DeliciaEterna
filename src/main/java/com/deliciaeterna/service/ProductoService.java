package com.deliciaeterna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliciaeterna.dto.StockDTO;
import com.deliciaeterna.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	public List<StockDTO> getProductosAll() {
        return productoRepository.findAllProductos();
    }

    public List<StockDTO> getProductosBySucursalAndCategoria(Integer sucursalId, Integer categoriaId) {
        return productoRepository.findBySucursalAndCategoria(sucursalId, categoriaId);
    }

	 public List<StockDTO> getProductosByCategoria(Integer categoriaId) {
        return productoRepository.findByCategoria(categoriaId);
    }
	 
	 public List<StockDTO> getProductosBySucursal(Integer sucursalId) {
        return productoRepository.findBySucursal(sucursalId);
    }
}