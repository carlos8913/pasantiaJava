package com.pasantia.application.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.pasantia.application.dto.ProveedorDTO;
import com.pasantia.application.entity.Proveedor;
import com.pasantia.application.model.Response;
import com.pasantia.application.service.ProveedorService;

@Controller
@RequestMapping("/api/v1/proveedor")
@Api(tags="Maestro de proveedores")
public class ProveedorController {
	@Autowired
	private ProveedorService proveedorService;
	/**
	 * Crea un proveedor
	 * <p>
	 * Version:
	 * <ul>
	 * <li> 24-09-2022 [Nelson Roldan], version inicial.</li>
	 * </ul>
	 * </p>
	 * @param proveedor ProveedorDTO.
	 * @return ResponseEntity<Response<ProveedorDTO>>
	 */
	
	@PostMapping
	@ApiOperation(value="Crear proveedor", notes="crea un proveedor o agencia de viajes")
	public ResponseEntity<Proveedor> crearProveedor( @RequestBody ProveedorDTO proveedor){
		System.out.println("****NOMBRE " + proveedor.getNombre());
		System.out.println("****DIRECCION " + proveedor.getDireccion());
		System.out.println("****TELEFONO " + proveedor.getTelefono());
		System.out.println("****EMAIL " + proveedor.getEmail());


		return new ResponseEntity<>(proveedorService.create(proveedor), HttpStatus.CREATED);
	}
}
