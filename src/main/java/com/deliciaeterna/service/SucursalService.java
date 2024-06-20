package com.deliciaeterna.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deliciaeterna.entity.Sucursal;
import com.deliciaeterna.repository.SucursalRepository;

@Service
public class SucursalService {
	
	@Autowired
	private SucursalRepository sucursalRepository;
	
    public List<Sucursal> findAll() {
        return sucursalRepository.findAll();
    }

    public Optional<Sucursal> findById(@PathVariable Integer id) {
        return sucursalRepository.findById(id);
    }

    public Sucursal save(@RequestBody Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    public void deleteById(@PathVariable Integer id) {
    	sucursalRepository.deleteById(id);
    }

}
