package br.fds.Persistencia;

import br.fds.Dominio.IRepProdutos;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class RepProdutosJPA implements IRepProdutos {
    IRepProdutosJPA repJPA;

    public RepProdutosJPA(IRepProdutosJPA repJPA) {
        this.repJPA = repJPA;
    }

    
}
