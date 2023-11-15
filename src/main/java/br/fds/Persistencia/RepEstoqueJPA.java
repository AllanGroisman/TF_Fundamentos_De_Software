package br.fds.Persistencia;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.fds.Dominio.Entidades.Entidades.Estoque;

@Repository
@Primary
public class RepEstoqueJPA implements IRepEstoqueJPA {
    IRepEstoqueJPA repJPA;

    public RepEstoqueJPA(IRepEstoqueJPA repJPA) {
        this.repJPA = repJPA;
    }

    
}
