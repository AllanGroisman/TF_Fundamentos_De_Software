package br.fds.Dominio.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Produto {
    @Id
    private long codigo;
    private String descricao;
    private double preco;

    // Quantidades em estoque
    private int qtd_min;
    private int qtd_max;
    private int qtd_atual;

    // Construtor padrao
    public Produto(long codigo, String descricao, double preco, int qtdMin, int qtdMax, int qtdAtual) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.qtd_min = qtdMin;
        this.qtd_max = qtdMax;
        this.qtd_atual = qtdAtual;
    }

    // construtor vazio
    protected Produto() {
    }
    

    // GET
    public long getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    };

    public int getQtd_min() {
        return qtd_min;
    }

    public int getQtd_max() {
        return qtd_max;
    }

    public int getQtd_atual() {
        return qtd_atual;
    }

    // SET
    public void setQtd_atual(int qtdAtual) {
        this.qtd_atual = qtdAtual;
    }

    @Override
    public String toString() {
        return "Produto [codProd=" + codigo + ", descProd=" + descricao + ", precoProd=" + preco + "]";
    }
}
