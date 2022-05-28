package br.edu.fateczl.ExemploREST.controller;

import java.util.List;

import br.edu.fateczl.ExemploREST.model.dto.MatriculaDTO;
import br.edu.fateczl.ExemploREST.model.dto.MatriculaRelatorioDTO;
import br.edu.fateczl.ExemploREST.model.entity.Matricula;

public interface IMatriculaController {

	public List<Matricula> buscarMatriculas();
	public List<Matricula> buscarMatricula(String codigo);
	public List<MatriculaRelatorioDTO> listaMatricula(String codigo);
	
}
