package models;


import java.math.BigDecimal;

public class Produto {
    private int codigo;
    private String descricao;
    private String tipo;
    private double valor;

    public Produto() {

    }

    public Produto(int codigo, String descricao, String tipo, double valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double setPrecoVenda(BigDecimal bigDecimal) {
        return valor;
    }
}

