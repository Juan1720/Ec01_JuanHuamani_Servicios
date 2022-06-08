package com.idat.pe.ec1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.pe.ec1.model.Universidad;
import com.idat.pe.ec1.service.UniversidadService;

@Controller
@RequestMapping("/universidad/v1")
public class UniversidadController {
	
	@Autowired
	private UniversidadService serviceUniversidad;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<Universidad>> listar(){
		return new ResponseEntity<List<Universidad>>(serviceUniversidad.listarUniversidad(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Universidad universidad) {
		serviceUniversidad.guardarUniversidad(universidad);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		Universidad universidad= serviceUniversidad.obtenerUniversidadId(id);
		if(universidad != null) {
			serviceUniversidad.eliminarUniversidad(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody Universidad universidad){
		
		Universidad u = serviceUniversidad.obtenerUniversidadId(universidad.getIdUniversidad());
		if(u != null) {
			serviceUniversidad.actualizarUniversidad(universidad);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Universidad> obtenerId(@PathVariable Integer id){
		
		Universidad u  = serviceUniversidad.obtenerUniversidadId(id);
		if(u != null) {
			return new ResponseEntity<Universidad>(serviceUniversidad.obtenerUniversidadId(id),HttpStatus.OK);
		}
		
		return new ResponseEntity<Universidad>(HttpStatus.NOT_FOUND);
	}

}
