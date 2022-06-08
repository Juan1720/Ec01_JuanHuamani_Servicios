package com.idat.pe.ec1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.ec1.model.Universidad;
import com.idat.pe.ec1.repository.UniversidadRepository;

@Service
public class UniversidadServiceImpl implements UniversidadService {

	@Autowired
	private UniversidadRepository repoUniversidad;
	
	@Override
	public void guardarUniversidad(Universidad universidad) {

		repoUniversidad.save(universidad);
		
	}

	@Override
	public void actualizarUniversidad(Universidad universidad) {
		
		repoUniversidad.saveAndFlush(universidad);
		
	}

	@Override
	public void eliminarUniversidad(Integer id) {
		
		repoUniversidad.deleteById(id);
		
	}

	@Override
	public List<Universidad> listarUniversidad() {
		
		return repoUniversidad.findAll();
	}

	@Override
	public Universidad obtenerUniversidadId(Integer id) {
		
		return repoUniversidad.findById(id).orElse(null);
	}

}
