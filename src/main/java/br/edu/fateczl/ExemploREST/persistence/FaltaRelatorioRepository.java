package br.edu.fateczl.ExemploREST.persistence;

import br.edu.fateczl.ExemploREST.model.entity.FaltaRelatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FaltaRelatorioRepository extends JpaRepository<FaltaRelatorio, String> {
    @Query(value = "SELECT * FROM faltas_turma(?1)", nativeQuery = true)
    List<FaltaRelatorio> findAllFaltasRelatorio(String codigo);
}
