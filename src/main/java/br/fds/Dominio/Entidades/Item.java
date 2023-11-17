package br.fds.Dominio.Entidades;

import jakarta.persistence.Entity;

@Entity
public class Item {
    private long IdProd;
    private int qtd;

    public Item(long idProd, int qtd) {
        IdProd = idProd;
        this.qtd = qtd;
    }

    public long getIdProd() {
        return IdProd;
    }

    public void setIdProd(long idProd) {
        IdProd = idProd;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    @Override
    public String toString() {
        return "Item [IdProd=" + IdProd + ", qtd=" + qtd + "]";
    }
    
    
}
