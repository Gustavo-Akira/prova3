package br.edu.fateczl.ExemploREST.model.dto;

import java.util.Date;

public class SaveFaltaDTO {
    private String ra;
    private String codigoDisciplina;
    private Date date;
    private Integer presenca;

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPresenca() {
        return presenca;
    }

    public void setPresenca(Integer presenca) {
        this.presenca = presenca;
    }

    @Override
    public String toString() {
        return "SaveFaltaDTO{" +
                "ra='" + ra + '\'' +
                ", codigoDisciplina='" + codigoDisciplina + '\'' +
                ", date=" + date +
                '}';
    }
}
