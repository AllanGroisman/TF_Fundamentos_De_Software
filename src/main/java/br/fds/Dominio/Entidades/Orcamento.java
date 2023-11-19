package br.fds.Dominio.Entidades;

import java.time.LocalDate;
import java.time.Month;
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

    public Orcamento(Pedido pedido, double custoTotal, LocalDate dataAtual, Double desconto) {
        this.custoTotal = custoTotal;
        this.pedido = pedido;
        this.data = dataAtual;
        this.desconto = desconto;
        this.calcularValorTotal();
    }

    protected Orcamento(){}

    //GETS
    public double calcularValorTotal() {
        //Comeca igual ao custo
        valorTotal = custoTotal;
        //Tira o desconto respectivo
        valorTotal -= (custoTotal * desconto);
        //Aplica o imposto
        valorTotal += (valorTotal*imposto);
        //retorna o valor
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
    public double getValorTotal() {
        return this.valorTotal;
    }
    public boolean getValidade(){
        //se não foi, tem que testar as datas
        int prazo = 0;
        Month mesCriacao = data.getMonth();
        //se o mes de criacao do orcamento é de baixa temporada, o prazo é de 35 dias
        if (mesCriacao == Month.JULY || mesCriacao == Month.DECEMBER || mesCriacao == Month.JANUARY || mesCriacao == Month.FEBRUARY) {
            prazo = 35;
        } else {
            //se não o prazo é de 21
            prazo = 21;
        }
        //Pega a data atual
        LocalDate dataAtual = LocalDate.now();
        //Pega uma data limite a partir da criacao do orcamento + o prazo em dias
        LocalDate dataLimite = data.plusDays(prazo); 
        //Se a data atual já é depois do limite, retorna falso
        if(dataAtual.isAfter(dataLimite)){
            return false;
        }
        //Se nao, retorna true (valido)
        return true;
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
