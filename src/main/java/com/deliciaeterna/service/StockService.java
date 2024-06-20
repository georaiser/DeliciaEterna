package com.deliciaeterna.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deliciaeterna.entity.Producto;
import com.deliciaeterna.entity.Stock;
import com.deliciaeterna.entity.StockId;
import com.deliciaeterna.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;
	
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    public List<Stock> findByIdSucursal(Integer idSucursal) {
        return stockRepository.findByIdSucursal(idSucursal);
    }
    
    public List<Stock> findByIdProducto(Integer idProducto) {
        return stockRepository.findByIdProducto(idProducto);
    }
    
    public List<Stock> findByIdSucursalAndIdProducto(Integer idSucursal, Integer idProducto){
		return stockRepository.findByIdSucursalAndIdProducto(idSucursal, idProducto);
    }
    

    
}
    
	