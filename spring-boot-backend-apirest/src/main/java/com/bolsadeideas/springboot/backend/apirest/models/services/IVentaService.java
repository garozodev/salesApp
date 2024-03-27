package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Venta;

public interface IVentaService {
	
	public List<Venta> findAll();
	
	public void save(Venta cliente);
	
	public Venta findById(Long id);
	
	public void delete(Venta cliente);

}
