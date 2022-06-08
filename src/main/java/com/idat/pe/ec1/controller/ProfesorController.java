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

import com.idat.pe.ec1.model.Profesor;
import com.idat.pe.ec1.service.ProfesorService;

@Controller
@RequestMapping("/profesor/v1")
public class ProfesorController {
	
	@Autowired
	private ProfesorService serviceProfesor;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<Profesor>> listar(){
		return new ResponseEntity<List<Profesor>>(serviceProfesor.listarProfesor(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Profesor profesor) {
		serviceProfesor.actualizarProfesor(profesor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		Profesor profesor= serviceProfesor.obtenerProfesorId(id);
		if(profesor != null) {
			serviceProfesor.eliminarProfesor(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody Profesor profesor){
		
		Profesor p = serviceProfesor.obtenerProfesorId(profesor.getIdProfesor());
		if(p != null) {
			serviceProfesor.actualizarProfesor(profesor);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Profesor> obtenerId(@PathVariable Integer id){
		
		Profesor p = serviceProfesor.obtenerProfesorId(id);
		if(p != null) {
			return new ResponseEntity<Profesor>(serviceProfesor.obtenerProfesorId(id),HttpStatus.OK);
		}
		
		return new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
	}

}
