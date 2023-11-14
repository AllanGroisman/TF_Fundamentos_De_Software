package br.fds.Dominio.Entidades.Entidades;

import java.util.Map;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String cliente;
    private Map<Long, Integer> listaProd; // long = prodId, Integer = qtdProd

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

}
