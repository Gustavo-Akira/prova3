package br.edu.fateczl.ExemploREST.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "disciplina")
public class Disciplina {

	@Id
	@Column(name = "codigo", length = 255)
	@NonNull
	private String codigo;

	@Column(name = "nome", length = 40)
	@NonNull
	private String nome;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "{" +
				"codigo='" + codigo + '\'' +
				", nome='" + nome + '\'' +
				'}';
	}
}
