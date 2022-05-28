package br.edu.fateczl.ExemploREST.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
public class FaltaRelatorio {
    @Id
    @Column(name = "RA_Aluno")
    private String ra;
    @Column(name = "Nome_Aluno")
    private String nome;
    @Column(name = "Data1")
    private String data1;
    @Column(name = "Data2")
    private String data2;
    @Column(name = "Data3")
    private String data3;
    @Column(name = "Data4")
    private String data4;
    @Column(name = "Data5")
    private String data5;
    @Column(name = "Data6")
    private String data6;
    @Column(name = "Data7")
    private String data7;
    @Column(name = "Data8")
    private String data8;
    @Column(name = "Data9")
    private String data9;
    @Column(name = "Data10")
    private String data10;
    @Column(name = "Data11")
    private String data11;
    @Column(name = "Data12")
    private String data12;
    @Column(name = "Data13")
    private String data13;
    @Column(name = "Data14")
    private String data14;
    @Column(name = "Data15")
    private String data15;
    @Column(name = "Data16")
    private String data16;
    @Column(name = "Data17")
    private String data17;
    @Column(name = "Data18")
    private String data18;
    @Column(name = "Data19")
    private String data19;
    @Column(name = "Data20")
    private String data20;
    @Column(name = "Total_Faltas")
    private Integer totalFaltas;

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public String getData3() {
        return data3;
    }

    public void setData3(String data3) {
        this.data3 = data3;
    }

    public String getData4() {
        return data4;
    }

    public void setData4(String data4) {
        this.data4 = data4;
    }

    public String getData5() {
        return data5;
    }

    public void setData5(String data5) {
        this.data5 = data5;
    }

    public String getData6() {
        return data6;
    }

    public void setData6(String data6) {
        this.data6 = data6;
    }

    public String getData7() {
        return data7;
    }

    public void setData7(String data7) {
        this.data7 = data7;
    }

    public String getData8() {
        return data8;
    }

    public void setData8(String data8) {
        this.data8 = data8;
    }

    public String getData9() {
        return data9;
    }

    public void setData9(String data9) {
        this.data9 = data9;
    }

    public String getData10() {
        return data10;
    }

    public void setData10(String data10) {
        this.data10 = data10;
    }

    public String getData11() {
        return data11;
    }

    public void setData11(String data11) {
        this.data11 = data11;
    }

    public String getData12() {
        return data12;
    }

    public void setData12(String data12) {
        this.data12 = data12;
    }

    public String getData13() {
        return data13;
    }

    public void setData13(String data13) {
        this.data13 = data13;
    }

    public String getData14() {
        return data14;
    }

    public void setData14(String data14) {
        this.data14 = data14;
    }

    public String getData15() {
        return data15;
    }

    public void setData15(String data15) {
        this.data15 = data15;
    }

    public String getData16() {
        return data16;
    }

    public void setData16(String data16) {
        this.data16 = data16;
    }

    public String getData17() {
        return data17;
    }

    public void setData17(String data17) {
        this.data17 = data17;
    }

    public String getData18() {
        return data18;
    }

    public void setData18(String data18) {
        this.data18 = data18;
    }

    public String getData19() {
        return data19;
    }

    public void setData19(String data19) {
        this.data19 = data19;
    }

    public String getData20() {
        return data20;
    }

    public void setData20(String data20) {
        this.data20 = data20;
    }

    public Integer getTotalFaltas() {
        return totalFaltas;
    }

    public void setTotalFaltas(Integer totalFaltas) {
        this.totalFaltas = totalFaltas;
    }

    @Override
    public String toString() {
        return "FaltaRelatorio{" +
                "ra='" + ra + '\'' +
                ", nome='" + nome + '\'' +
                ", data1='" + data1 + '\'' +
                ", data2='" + data2 + '\'' +
                ", data3='" + data3 + '\'' +
                ", data4='" + data4 + '\'' +
                ", data5='" + data5 + '\'' +
                ", data6='" + data6 + '\'' +
                ", data7='" + data7 + '\'' +
                ", data8='" + data8 + '\'' +
                ", data9='" + data9 + '\'' +
                ", data10='" + data10 + '\'' +
                ", data11='" + data11 + '\'' +
                ", data12='" + data12 + '\'' +
                ", data13='" + data13 + '\'' +
                ", data14='" + data14 + '\'' +
                ", data15='" + data15 + '\'' +
                ", data16='" + data16 + '\'' +
                ", data17='" + data17 + '\'' +
                ", data18='" + data18 + '\'' +
                ", data19='" + data19 + '\'' +
                ", data20='" + data20 + '\'' +
                ", totalFaltas=" + totalFaltas +
                '}';
    }
}
