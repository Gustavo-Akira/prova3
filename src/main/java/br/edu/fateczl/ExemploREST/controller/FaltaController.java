package br.edu.fateczl.ExemploREST.controller;

import br.edu.fateczl.ExemploREST.model.dto.SaveFaltaDTO;
import br.edu.fateczl.ExemploREST.model.entity.Falta;
import br.edu.fateczl.ExemploREST.model.entity.FaltaRelatorio;
import br.edu.fateczl.ExemploREST.persistence.AlunoRepository;
import br.edu.fateczl.ExemploREST.persistence.DisciplinaRepository;
import br.edu.fateczl.ExemploREST.persistence.FaltaRelatorioRepository;
import br.edu.fateczl.ExemploREST.persistence.FaltaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("rest")
public class FaltaController implements IFaltaController{

    @Autowired
    private FaltaRepository repository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private FaltaRelatorioRepository faltaRelatorioRepository;

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

    @GetMapping("falta/relatorio/{codigo}")
    public ResponseEntity<List<FaltaRelatorio>> getFaltasRelatorio(@PathVariable String codigo){
        return ResponseEntity.ok(faltaRelatorioRepository.findAllFaltasRelatorio(codigo));
    }
}
