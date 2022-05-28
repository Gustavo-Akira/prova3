package br.edu.fateczl.ExemploREST.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.ExemploREST.model.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.fateczl.ExemploREST.model.entity.Matricula;
import br.edu.fateczl.ExemploREST.model.entity.MatriculaRelatorio;
import br.edu.fateczl.ExemploREST.persistence.MatriculaRelatorioRepository;
import br.edu.fateczl.ExemploREST.persistence.MatriculaRepository;

@RestController
@RequestMapping("/rest")
public class MatriculaController implements IMatriculaController {

	@Autowired
	MatriculaRepository mRep;

	@Autowired
	MatriculaRelatorioRepository mrRep;
	
	@Override
	@GetMapping("/matricula")
	public List<Matricula> buscarMatriculas() {
		List<Matricula> matriculas = mRep.findAll();
		return matriculas;
	}

	@PostMapping("/matricula")
	public String saveMatricula(@RequestBody SaveMatriculaDTO dto){
		mRep.saveMatricula(dto.getRa(), dto.getCodigo());
		return "matricula salva com sucesso";
	}

	@GetMapping("/matricula/{codigo}")
	public List<Matricula> buscarMatricula(@PathVariable(value = "codigo") String codigo) {
		List<Matricula> matriculas = mRep.findByDisciplinaCodigo(codigo);
		return matriculas;
	}

	@Override
	@GetMapping("/matricula/lista/{codigo}")
	public List<MatriculaRelatorio> listaMatricula(@PathVariable(value = "codigo") String codigo) {
		List<MatriculaRelatorio> listaMatriculaRelatorio = mrRep.geraLista(codigo);
		return listaMatriculaRelatorio;
	}
	
	private MatriculaRelatorioDTO converteMRMRDTO(MatriculaRelatorio mat) {
		MatriculaRelatorioDTO mrDTO = new MatriculaRelatorioDTO();
		mrDTO.setRaAluno(mat.getRaAluno());
		mrDTO.setNomeAluno(mat.getNomeAluno());
		mrDTO.setCodigoDisicplina(mat.getCodigoDisicplina());
		mrDTO.setNomeDisciplina(mat.getNomeDisciplina());
		
		return mrDTO;
	}
	
	private List<MatriculaRelatorioDTO> converteListaMRListaMRDTO(List<MatriculaRelatorio> listaMat) {
		List<MatriculaRelatorioDTO> listaMRDTO = new ArrayList<MatriculaRelatorioDTO>();
		for (MatriculaRelatorio mat : listaMat) {
			MatriculaRelatorioDTO mrDTO = new MatriculaRelatorioDTO();
			mrDTO = converteMRMRDTO(mat);
			
			listaMRDTO.add(mrDTO);
		}
		return listaMRDTO;
	}


}
