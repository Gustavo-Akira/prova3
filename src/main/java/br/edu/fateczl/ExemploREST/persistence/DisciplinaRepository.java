package br.edu.fateczl.ExemploREST.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fateczl.ExemploREST.model.entity.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, String> {
	
	public Disciplina findByNome(String nome);

}
