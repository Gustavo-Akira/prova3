package br.edu.fateczl.ExemploREST.controller;

import br.edu.fateczl.ExemploREST.model.dto.AlunoDTO;
import br.edu.fateczl.ExemploREST.model.dto.DisciplinaDTO;
import br.edu.fateczl.ExemploREST.model.dto.FaltaDTO;
import br.edu.fateczl.ExemploREST.model.dto.SaveFaltaDTO;
import br.edu.fateczl.ExemploREST.model.entity.Falta;
import br.edu.fateczl.ExemploREST.persistence.AlunoRepository;
import br.edu.fateczl.ExemploREST.persistence.DisciplinaRepository;
import br.edu.fateczl.ExemploREST.persistence.FaltaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("rest")
public class FaltaController implements IFaltaController{

    @Autowired
    private FaltaRepository repository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Override
    @PostMapping("falta")
    public ResponseEntity<String> saveFalta(@RequestBody @Valid List<SaveFaltaDTO> dtos) {
        for (SaveFaltaDTO dto :
                dtos) {
            repository.saveFalta(dto.getRa(),dto.getCodigoDisciplina(),dto.getDate(),dto.getPresenca());
        }
        return ResponseEntity.ok("Presenças contabilizadas");
    }

    @Override
    @GetMapping("falta/{codigo}")
    public ResponseEntity<List<Falta>> getFaltas(@PathVariable String codigo) {
        return ResponseEntity.ok(repository.findAllByDisciplina(disciplinaRepository.findById(codigo).orElseThrow()));
    }

    @PutMapping("falta")
    public ResponseEntity<String> updateFalta(@RequestBody @Valid List<SaveFaltaDTO> dtos) {
        for (SaveFaltaDTO dto :
                dtos) {
            repository.updateFalta(dto.getRa(),dto.getCodigoDisciplina(),dto.getDate(),dto.getPresenca());
        }
        return ResponseEntity.ok("Presenças atualizadas");
    }
}
