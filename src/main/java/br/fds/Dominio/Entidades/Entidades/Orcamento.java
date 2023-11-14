package br.fds.Dominio.Entidades.Entidades;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orcamento {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    LocalDate data;
    Pedido pedido;

    //valores
    double custoTotal; //valor original
    double imposto = 0.1;
    double desconto;
    double valorTotal; // valor p/ cliente pós descontos

    public Orcamento(Pedido pedido) {
        this.pedido = pedido;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

}
