package br.edu.fateczl.ExemploREST.controller;

import br.edu.fateczl.ExemploREST.model.dto.FaltaDTO;
import br.edu.fateczl.ExemploREST.model.dto.SaveFaltaDTO;
import br.edu.fateczl.ExemploREST.model.entity.Falta;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFaltaController {
    ResponseEntity<String> saveFalta(List<SaveFaltaDTO> dtos);
    ResponseEntity<List<Falta>> getFaltas(String codigo);
}
