package br.edu.fateczl.ExemploREST.persistence;

import br.edu.fateczl.ExemploREST.model.entity.Disciplina;
import br.edu.fateczl.ExemploREST.model.entity.Falta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface FaltaRepository extends JpaRepository<Falta, Integer> {
    List<Falta> findAllByDisciplina(Disciplina disciplina);
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO faltas(ra_aluno,codigo_disciplina,data,presenca) VALUES(?1,?2,?3,?4)", nativeQuery = true)
    void saveFalta(String ra, String codigo, Date date, Integer presenca);
    @Transactional
    @Modifying
    @Query(value = "UPDATE faltas SET presenca = ?4 WHERE ra_aluno=?1 AND codigo_disciplina=?2 AND data=?3", nativeQuery = true)
    void updateFalta(String ra, String codigo, Date date, Integer presenca);
}
