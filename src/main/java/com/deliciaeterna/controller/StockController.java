package com.deliciaeterna.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.deliciaeterna.service.CategoriaService;
import com.deliciaeterna.service.ProductoService;
import com.deliciaeterna.service.StockService;
import com.deliciaeterna.service.SucursalService;

@Controller
@RequestMapping("/stock")
public class StockController {
	
	@Autowired
	public SucursalService sucursalService;
	
	@Autowired
	public CategoriaService categoriaService;
	
	@Autowired
	public StockService stockService;
	
	@Autowired
	public ProductoService productoService;
	
	@GetMapping("/sucursal_categoria")
	public String sucursalCategoria(Model model) {
		model.addAttribute("sucursales", sucursalService.findAll());
        model.addAttribute("categorias", categoriaService.findAll());
        return "actions/stock_form";	
	}
	
	 @GetMapping("/search")
	    public String searchStock(@RequestParam(required = false) Integer sucursalId,
	            					@RequestParam(required = false) Integer categoriaId, 
	            					Model model) {
		model.addAttribute("sucursales", sucursalService.findAll());
		model.addAttribute("categorias", categoriaService.findAll());
		
		model.addAttribute("selectedSucursal", sucursalId);
		model.addAttribute("selectedCategoria", categoriaId);
		
		if (sucursalId != null) {
			model.addAttribute("stocks", productoService.getProductosBySucursal(sucursalId));
		} else {
			model.addAttribute("stocks", productoService.getProductosAll());
		}
		
		if (categoriaId != null) {
			model.addAttribute("stocks", productoService.getProductosByCategoria(categoriaId));
		}
		
		if (sucursalId != null && categoriaId != null) {
			model.addAttribute("stocks", productoService.getProductosBySucursalAndCategoria(sucursalId, categoriaId));
		}
		return "actions/stock_form";
    }
}
	
