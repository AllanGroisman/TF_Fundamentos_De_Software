
package br.fds.Dominio.Entidades;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private long id;
    Set<Produto> prodEstoque;

    // construtor padrao
    public Estoque(long id) {
        this.id = id;
        this.prodEstoque = new HashSet<>();
    }

    // construtor vazio
    protected Estoque() {
    }

    public void adicionarProduto(Produto produto){
        prodEstoque.add(produto);
    }

    

}
