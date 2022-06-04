package br.edu.fateczl.ExemploREST.controller;

import br.edu.fateczl.ExemploREST.model.dto.SaveFaltaDTO;
import br.edu.fateczl.ExemploREST.model.entity.Falta;
import br.edu.fateczl.ExemploREST.model.entity.FaltaRelatorio;
import br.edu.fateczl.ExemploREST.persistence.AlunoRepository;
import br.edu.fateczl.ExemploREST.persistence.DisciplinaRepository;
import br.edu.fateczl.ExemploREST.persistence.FaltaRelatorioRepository;
import br.edu.fateczl.ExemploREST.persistence.FaltaRepository;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private JdbcTemplate jdbc;


    @Override
    @PostMapping("falta")
    public ResponseEntity<String> saveFalta(@RequestBody @Valid List<SaveFaltaDTO> dtos) {
        for (SaveFaltaDTO dto :
                dtos) {
            System.out.println(dto);
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

    @GetMapping("falta/relatorio/pdf/{codigo}")
    public ResponseEntity<byte[]>  getFaltasPDF(HttpServletRequest request, @PathVariable String codigo) throws SQLException, JRException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Map fillParams = new HashMap<>();
        fillParams.put("Parameter1", codigo);
        Connection connection = jdbc.getDataSource().getConnection();
        ServletContext servlet = request.getServletContext();
        String caminhoJasper = servlet.getRealPath("relatorios") + File.separator + "relatorio.jasper";
        JasperPrint print = JasperFillManager.fillReport(caminhoJasper, fillParams, connection);
        byte[] bytes= JasperExportManager.exportReportToPdf(print);

        String nomeRelatorio=  "relatorio.pdf";
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).header("Content-Disposition", "filename=\"" + nomeRelatorio + "\"").body(bytes);
    }
}
