package br.edu.fateczl.ExemploREST.model.dto;

public class SaveMatriculaDTO {
    private String codigo;
    private String ra;

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getRa() {
        return ra;
    }

    @Override
    public String toString() {
        return "SaveMatriculaDTO{" +
                "codigo='" + codigo + '\'' +
                ", ra='" + ra + '\'' +
                '}';
    }
}
