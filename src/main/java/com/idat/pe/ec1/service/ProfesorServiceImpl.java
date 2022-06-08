package com.idat.pe.ec1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.ec1.model.Profesor;
import com.idat.pe.ec1.repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService {

	@Autowired
	private ProfesorRepository repoProfesor;
	
	@Override
	public void guardarProfesor(Profesor profesor) {
		
		repoProfesor.save(profesor);
		
	}

	@Override
	public void actualizarProfesor(Profesor profesor) {
		
		repoProfesor.saveAndFlush(profesor);
		
	}

	@Override
	public void eliminarProfesor(Integer id) {
		
		repoProfesor.deleteById(id);
		
	}

	@Override
	public List<Profesor> listarProfesor() {
		
		return repoProfesor.findAll();
	}

	@Override
	public Profesor obtenerProfesorId(Integer id) {
		
		return repoProfesor.findById(id).orElse(null);
	}

}
