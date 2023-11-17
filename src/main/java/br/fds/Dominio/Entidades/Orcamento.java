package br.fds.Dominio.Entidades;

import java.time.LocalDate;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Orcamento {
   //atributos padrão
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate data;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    //valores
    private double custoTotal = 10; //valor original
    private double imposto = 0.1;
    private double desconto = 0.5;
    private double valorTotal = 10; // valor p/ cliente pós descontos

    public Orcamento(Pedido pedido) {
        this.pedido = pedido;
    }

    protected Orcamento(){}

    public double getValorTotal() {
        return valorTotal;
    }

    //no desconto trocar para fabrica
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public Map<Long,Integer> getListaPedido() {
        return pedido.getListaProd();
    }

    public String getCliente(){
        return pedido.getCliente();
    }

    public LocalDate getData() {
        return data;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    @Override
    public String toString() {
        return "Orcamento [id=" + id + ", data=" + data + ", pedido=" + pedido.toString() + ", custoTotal=" + custoTotal
                + ", imposto=" + imposto + ", desconto=" + desconto + ", valorTotal=" + valorTotal + ", cliente="
                + pedido.getCliente() + "]";
    }


    
    public Long getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }


}
