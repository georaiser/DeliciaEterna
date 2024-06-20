package com.deliciaeterna.repository;


import com.deliciaeterna.entity.Stock;
import com.deliciaeterna.entity.StockId;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, StockId> {

	List<Stock> findByIdProducto(Integer idProducto);
	
	List<Stock> findByIdSucursal(Integer idSucursal);
	
	List<Stock> findByIdSucursalAndIdProducto(Integer idSucursal, Integer idProducto);
	
}