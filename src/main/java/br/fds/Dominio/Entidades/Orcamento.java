package br.fds.Dominio.Entidades;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orcamento")
public class Orcamento {
   //atributos padrão
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    LocalDate data;
    
    //Pedido correspondente com cliente e lista de itens
    private Pedido pedido;

    //valores
    double custoTotal; //valor original
    double imposto = 0.1;
    double desconto;
    double valorTotal; // valor p/ cliente pós descontos

    public Orcamento(Pedido pedido) {
        this.pedido = pedido;
    }

    protected Orcamento(){}

    public double getValorTotal() {
        return valorTotal;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public Map<Long,Integer> getListaPedido() {
        return pedido.getListaProd();
    }

    public Pedido getPedido() {
        return pedido;
    }

}
