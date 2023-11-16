package br.fds.Dominio.Entidades;

import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cliente;

    @ElementCollection
    @CollectionTable(name = "pedido_produto_mapping", joinColumns = @JoinColumn(name = "pedido_id"))
    @MapKeyColumn(name = "produto_id")
    @Column(name = "quantidade")
    private Map<Long,Integer> listaProd;
    
    public Pedido(String cliente, Map<Long, Integer> listaProd) {
        this.cliente = cliente;
        this.listaProd = listaProd;
    }

    protected Pedido() {
    }

    public String getCliente() {
        return cliente;
    }

    public Map<Long, Integer> getListaProd() {
        return listaProd;
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + "]";
    }

    

}
