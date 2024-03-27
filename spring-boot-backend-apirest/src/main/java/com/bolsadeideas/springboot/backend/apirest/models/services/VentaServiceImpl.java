package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.backend.apirest.models.dao.IVentaDao;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Venta;

@Service
public class VentaServiceImpl implements IVentaService{

	@Autowired
	private IVentaDao ventaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Venta> findAll() {
		return (List<Venta>) ventaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Venta venta) {
		ventaDao.save(venta);
	}

	@Override
	@Transactional(readOnly = true)
	public Venta findById(Long id) {
		return ventaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Venta venta) {
		ventaDao.delete(venta);
		
	}

}
