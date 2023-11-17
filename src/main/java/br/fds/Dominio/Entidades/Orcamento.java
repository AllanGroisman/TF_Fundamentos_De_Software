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
    private boolean efetuado = false;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    //valores
    private double custoTotal; //valor original
    private double imposto = 0.1;
    private double desconto;
    private double valorTotal; // valor p/ cliente pós descontos

    public Orcamento(Pedido pedido, double custoTotal, LocalDate dataAtual) {
        this.custoTotal = custoTotal;
        this.pedido = pedido;
        this.data = dataAtual;
    }

    protected Orcamento(){}

    //GETS
    public double getValorTotal() {
        return valorTotal;
    }

    public Map<Long,Integer> getListaPedido() {
        return pedido.getListaProd();
    }
    //get cliente que fica no pedido.
    public String getCliente(){
        return pedido.getCliente();
    }

    public LocalDate getData() {
        return data;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public Long getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }
     public boolean getEfetuado() {
        return efetuado;
    }

    

    @Override
    public String toString() {
        return "Orcamento [id=" + id + ", data=" + data + ", pedido=" + pedido.toString() + ", custoTotal=" + custoTotal
                + ", imposto=" + imposto + ", desconto=" + desconto + ", valorTotal=" + valorTotal + ", cliente="
                + pedido.getCliente() + "]";
    }

    //SETS E OUTROS
    //no desconto trocar para fabrica
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
    public void setEfetuado(boolean efetuado) {
        this.efetuado = efetuado;
    }
}
