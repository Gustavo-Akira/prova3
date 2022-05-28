package br.edu.fateczl.ExemploREST.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fateczl.ExemploREST.model.entity.Matricula;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {

	public List<Matricula> findByDisciplinaCodigo(String codigo);
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO matricula(ra_aluno,codigo_disciplina) VALUES (?1,?2)",nativeQuery = true)
	void saveMatricula(String ra, String codigo);
}
