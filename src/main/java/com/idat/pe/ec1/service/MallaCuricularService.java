package com.idat.pe.ec1.service;

import java.util.List;

import com.idat.pe.ec1.model.MallaCuricular;

public interface MallaCuricularService {
	
	void guardarMalla(MallaCuricular mallaCuricular);
	void actualizarMalla(MallaCuricular mallaCuricular);
	void eliminarMalla(Integer id);
	List<MallaCuricular> listarMalla();
	MallaCuricular obtenerMallaId(Integer id);
	

}
