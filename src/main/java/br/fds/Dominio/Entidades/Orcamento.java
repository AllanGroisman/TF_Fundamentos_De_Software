package br.fds.Dominio.Entidades;

import java.time.LocalDate;
import java.util.Map;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orcamento {
   //atributos padrão
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    LocalDate data;
    
    //Pedido correspondente com cliente e lista de itens
    private Pedido pedido;

    //valores
    double custoTotal = 10; //valor original
    double imposto = 0.1;
    double desconto = 0.5;
    double valorTotal = 10; // valor p/ cliente pós descontos

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
        return "Orcamento [id=" + id + ", data=" + data + ", pedido=" + pedido + ", custoTotal=" + custoTotal
                + ", imposto=" + imposto + ", desconto=" + desconto + ", valorTotal=" + valorTotal + ", cliente="
                + pedido.getCliente() + "]";
    }


}
