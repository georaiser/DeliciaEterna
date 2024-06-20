package com.deliciaeterna.repository;

import com.deliciaeterna.dto.StockDTO;
import com.deliciaeterna.entity.Producto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
	@Query("SELECT NEW com.deliciaeterna.dto.StockDTO(s.idSucursal, s.nombre, cp.nombre, p.idProducto, p.nombreProducto, st.stock) " +
           "FROM Sucursal s " +
           "JOIN s.stocks st " +
           "JOIN st.producto p " +
           "JOIN p.categoriaProducto cp ")
    List<StockDTO> findAllProductos();

	@Query("SELECT NEW com.deliciaeterna.dto.StockDTO(s.idSucursal, s.nombre, cp.nombre, p.idProducto, p.nombreProducto, st.stock) " +
           "FROM Sucursal s " +
           "JOIN s.stocks st " +
           "JOIN st.producto p " +
           "JOIN p.categoriaProducto cp " +
           "WHERE s.idSucursal = :sucursalId AND cp.idCategoriaProducto = :categoriaId")
    List<StockDTO> findBySucursalAndCategoria(@Param("sucursalId") Integer sucursalId, @Param("categoriaId") Integer categoriaId);
    
    
	@Query("SELECT NEW com.deliciaeterna.dto.StockDTO(s.idSucursal, s.nombre, cp.nombre, p.idProducto, p.nombreProducto, st.stock) " +
            "FROM Sucursal s " +
            "JOIN s.stocks st " +
            "JOIN st.producto p " +
            "JOIN p.categoriaProducto cp " +
            "WHERE cp.idCategoriaProducto = :categoriaId")
     List<StockDTO> findByCategoria(@Param("categoriaId") Integer categoriaId);
    
	@Query("SELECT NEW com.deliciaeterna.dto.StockDTO(s.idSucursal, s.nombre, cp.nombre, p.idProducto, p.nombreProducto, st.stock) " +
            "FROM Sucursal s " +
            "JOIN s.stocks st " +
            "JOIN st.producto p " +
            "JOIN p.categoriaProducto cp " +
            "WHERE s.idSucursal = :sucursalId")
     List<StockDTO> findBySucursal(@Param("sucursalId") Integer sucursalId);   
    
}







