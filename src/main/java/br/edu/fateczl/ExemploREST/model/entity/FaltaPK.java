package br.edu.fateczl.ExemploREST.model.entity;

import java.io.Serializable;
import java.util.Date;

public class FaltaPK implements Serializable {
    private static final long serialVersionUID = 1L;
    private Aluno aluno;
    private Disciplina disciplina;
    private Date date;

    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    public Disciplina getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Falta [aluno=" + aluno + ", disciplina=" + disciplina + "]";
    }
}
