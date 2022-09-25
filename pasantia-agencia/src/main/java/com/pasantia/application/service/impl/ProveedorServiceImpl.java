package com.pasantia.application.service.impl;

import com.pasantia.application.repository.ProveedorRepository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasantia.application.dto.ProveedorDTO;
import com.pasantia.application.entity.Proveedor;
import com.pasantia.application.service.ProveedorService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProveedorServiceImpl implements ProveedorService {
	@Autowired
	private ProveedorRepository proveedorRepositoryYY;
	
	@Override
	public Proveedor create(ProveedorDTO proveedor) {
		try {
			Date fecha = new Date();
			Proveedor proveedorToSave = new Proveedor();
			proveedorToSave.setNombre(proveedor.getNombre());
			proveedorToSave.setTelefono(proveedor.getTelefono());
			proveedorToSave.setEmail(proveedor.getEmail());
			proveedorToSave.setDireccion(proveedor.getDireccion());
			proveedorToSave.setFechaCreacion(new Date());
			return proveedorRepositoryYY.save(proveedorToSave);
		}catch(Exception ex)
		{
			System.out.println("****ERROR: " + ex.toString());
			return null;
		}
	}

}
