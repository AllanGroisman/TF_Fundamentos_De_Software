package br.fds.Dominio.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    long codProd;
    String descProd;
    double precoProd;

    //Quantidades em estoque
    int qtdMin;
    int qtdMax;
    int qtdAtual = 0;

    //Construtor padrao
    public Produto(long codProd, String descProd, double precoProd, int qtdMin, int qtdMax, int qtdAtual) {
        this.codProd = codProd;
        this.descProd = descProd;
        this.precoProd = precoProd;
        this.qtdMin = qtdMin;
        this.qtdMax = qtdMax;
    }

    // construtor vazio
    protected Produto() {
    }

    @Override
    public String toString() {
        return "Produto [codProd=" + codProd + ", descProd=" + descProd + ", precoProd=" + precoProd + "]";
    }

    //GET
    public long getCodProd() {
        return codProd;
    }

    public String getDescProd() {
        return descProd;
    }

    public double getPrecoProd() {
        return precoProd;
    };

    public int getQtdMin() {
        return qtdMin;
    }

    public int getQtdMax() {
        return qtdMax;
    }

    public int getQtdAtual() {
        return qtdAtual;
    }

    //SET
    public void setQtdAtual(int qtdAtual) {
        this.qtdAtual = qtdAtual;
    }
}
