package com.idat.pe.ec1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.ec1.model.Curso;
import com.idat.pe.ec1.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {
	
	@Autowired
	private CursoRepository repoCurso;

	@Override
	public void guardarCurso(Curso curso) {
		repoCurso.save(curso);
		
	}

	@Override
	public void actualizarCurso(Curso curso) {
		repoCurso.saveAndFlush(curso);
		
	}

	@Override
	public void eliminarCurso(Integer id) {
		repoCurso.deleteById(id);
		
	}

	@Override
	public List<Curso> listarCursos() {
		
		return repoCurso.findAll();
	}

	@Override
	public Curso obtenerCursoId(Integer id) {
		
		return repoCurso.findById(id).orElse(null);
	}

}
