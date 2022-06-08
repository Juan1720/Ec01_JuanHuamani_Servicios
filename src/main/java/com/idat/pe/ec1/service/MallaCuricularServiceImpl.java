package com.idat.pe.ec1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.ec1.model.MallaCuricular;
import com.idat.pe.ec1.repository.MallaCuricularRepository;

@Service
public class MallaCuricularServiceImpl implements MallaCuricularService {

	@Autowired
	private MallaCuricularRepository repoMalla;
	
	@Override
	public void guardarMalla(MallaCuricular mallaCuricular) {
		
		repoMalla.save(mallaCuricular);
		
	}

	@Override
	public void actualizarMalla(MallaCuricular mallaCuricular) {
		
		repoMalla.saveAndFlush(mallaCuricular);
		
	}

	@Override
	public void eliminarMalla(Integer id) {
		
		repoMalla.deleteById(id);
	}

	@Override
	public List<MallaCuricular> listarMalla() {
		
		return repoMalla.findAll();
	}

	@Override
	public MallaCuricular obtenerMallaId(Integer id) {
		
		return repoMalla.findById(id).orElse(null);
	}

}
