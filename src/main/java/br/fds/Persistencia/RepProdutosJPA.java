package br.fds.Persistencia;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class RepProdutosJPA implements IRepProdutosJPA {
    IRepProdutosJPA repJPA;

    public RepProdutosJPA(IRepProdutosJPA repJPA) {
        this.repJPA = repJPA;
    }

    
}
