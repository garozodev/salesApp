package com.bolsadeideas.springboot.backend.apirest.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Venta;
import com.bolsadeideas.springboot.backend.apirest.models.services.IVentaService;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class VentaRestController {

@Autowired private IVentaService service;

	@GetMapping("/ventas")
	public List<Venta> index() {
		return service.findAll();
	}

	@GetMapping("/ventas/{id}")
	public Venta show(@PathVariable Long id) {
		return this.service.findById(id);
	}

	@PostMapping("/ventas")
	@ResponseStatus(HttpStatus.CREATED)
	public Venta create(@RequestBody Venta cliente) {
		cliente.setCreateAt(new Date());
		this.service.save(cliente);
		return cliente;
	}

	@PutMapping("/ventas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Venta update(@RequestBody Venta cliente, @PathVariable Long id) {
		Venta currentCliente = this.service.findById(id);
		currentCliente.setNombre(cliente.getNombre());
		currentCliente.setApellido(cliente.getApellido());
		currentCliente.setEmail(cliente.getEmail());
		this.service.save(currentCliente);
		return currentCliente;
	}

}
