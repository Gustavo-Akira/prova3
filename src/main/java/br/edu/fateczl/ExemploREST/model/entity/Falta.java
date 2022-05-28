package br.edu.fateczl.ExemploREST.model.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "faltas")
@IdClass(FaltaPK.class)
public class Falta {

    public Falta(){

    }

    public Falta(Aluno aluno, Disciplina disciplina, Date date){
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.date = date;
    }

    @Id
    @ManyToOne(targetEntity = Aluno.class)
    @JoinColumn(name = "ra_aluno")
    @NonNull
    private Aluno aluno;

    @Id
    @ManyToOne(targetEntity = Disciplina.class)
    @JoinColumn(name = "codigo_disciplina")
    @NonNull
    private Disciplina disciplina;

    @Id
    @Temporal(TemporalType.DATE)
    @Column(name = "data")
    private Date date;

    @Column(name = "presenca")
    private int presenca;

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

    public void setPresenca(int presenca) {
        this.presenca = presenca;
    }

    public int getPresenca() {
        return presenca;
    }

    @Override
    public String toString() {
        return "Falta{" +
                "aluno=" + aluno +
                ", disciplina=" + disciplina +
                ", date=" + date +
                ", presenca=" + presenca +
                '}';
    }
}
