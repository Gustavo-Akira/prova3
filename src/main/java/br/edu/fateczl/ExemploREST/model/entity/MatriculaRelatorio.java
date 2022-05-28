package br.edu.fateczl.ExemploREST.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import org.springframework.lang.NonNull;

@Entity
@IdClass(MatriculaRelatorioPK.class)
public class MatriculaRelatorio {
	
	@Id
	@Column(name = "ra_aluno", length = 13)
	@NonNull
	private String raAluno;
	
	@Column(name = "nome_aluno", length = 50)
	@NonNull
	private String nomeAluno;
	
	@Id
	@Column(name = "codigo_disciplina")
	@NonNull
	private String codigoDisicplina;
	
	@Column(name = "nome_disciplina", length = 40)
	@NonNull
	private String nomeDisciplina;
	
	public String getRaAluno() {
		return raAluno;
	}
	public void setRaAluno(String raAluno) {
		this.raAluno = raAluno;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public String getCodigoDisicplina() {
		return codigoDisicplina;
	}
	public void setCodigoDisicplina(String codigoDisicplina) {
		this.codigoDisicplina = codigoDisicplina;
	}
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	@Override
	public String toString() {
		return "MatriculaRelatorio [raAluno=" + raAluno + ", nomeAluno=" + nomeAluno
				+ ", codigoDisicplina=" + codigoDisicplina + ", nomeDisciplina=" + nomeDisciplina + "]";
	}
}
