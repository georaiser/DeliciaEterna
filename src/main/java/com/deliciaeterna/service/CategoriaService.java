package com.deliciaeterna.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deliciaeterna.entity.CategoriaProducto;
import com.deliciaeterna.repository.CategoriaProductoRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaProductoRepository categoriaRepository;
	
    public List<CategoriaProducto> findAll() {
        return categoriaRepository.findAll();
    }

    public Optional<CategoriaProducto> findById(@PathVariable Integer id) {
        return categoriaRepository.findById(id);
    }

    public CategoriaProducto save(@RequestBody CategoriaProducto categoria) {
        return categoriaRepository.save(categoria);
    }

    public void deleteById(@PathVariable Integer id) {
    	categoriaRepository.deleteById(id);
    }
}
