package br.edu.fateczl.ExemploREST.model.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value = "disciplina")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class DisciplinaDTO {

	public DisciplinaDTO(){

	}


	public DisciplinaDTO(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	private String codigo;
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
		return "Disciplina [codigo=" + codigo + ", nome=" + nome + "]";
	}
	
}
