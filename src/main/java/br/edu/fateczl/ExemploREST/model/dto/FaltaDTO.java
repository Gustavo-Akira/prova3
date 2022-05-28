package br.edu.fateczl.ExemploREST.model.dto;

import java.util.Date;

public class FaltaDTO {
    public Date date;
    public AlunoDTO alunoDTO;
    public DisciplinaDTO disciplinaDTO;
    public int presenca;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AlunoDTO getAluno() {
        return alunoDTO;
    }

    public void setAluno(AlunoDTO alunoDTO) {
        this.alunoDTO = alunoDTO;
    }

    public DisciplinaDTO getDisciplina() {
        return disciplinaDTO;
    }

    public void setDisciplina(DisciplinaDTO disciplinaDTO) {
        this.disciplinaDTO = disciplinaDTO;
    }

    public int getPresenca() {
        return presenca;
    }

    public void setPresenca(int presenca) {
        this.presenca = presenca;
    }

    @Override
    public String toString() {
        return "FaltaDTO{" +
                "date=" + date +
                ", alunoDTO=" + alunoDTO +
                ", disciplinaDTO=" + disciplinaDTO +
                ", presenca=" + presenca +
                '}';
    }
}
