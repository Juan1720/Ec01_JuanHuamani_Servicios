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

import com.idat.pe.ec1.model.MallaCuricular;
import com.idat.pe.ec1.service.MallaCuricularService;

@Controller
@RequestMapping("/malla/v1")
public class MallaCurricularController {
	
	@Autowired
	private MallaCuricularService serviceMalla;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<MallaCuricular>> listar(){
		return new ResponseEntity<List<MallaCuricular>>(serviceMalla.listarMalla(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody MallaCuricular mallaCuricular) {
		serviceMalla.guardarMalla(mallaCuricular);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		MallaCuricular malla= serviceMalla.obtenerMallaId(id);
		if(malla != null) {
			serviceMalla.eliminarMalla(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody MallaCuricular malla){
		
		MallaCuricular m= serviceMalla.obtenerMallaId(malla.getIdMalla());
		if(m != null) {
			serviceMalla.actualizarMalla(malla);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<MallaCuricular> obtenerId(@PathVariable Integer id){
		
		MallaCuricular m = serviceMalla.obtenerMallaId(id);
		if(m != null) {
			return new ResponseEntity<MallaCuricular>(serviceMalla.obtenerMallaId(id),HttpStatus.OK);
		}
		
		return new ResponseEntity<MallaCuricular>(HttpStatus.NOT_FOUND);
	}

}
