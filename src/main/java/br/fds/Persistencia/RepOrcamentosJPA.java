package br.fds.Persistencia;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class RepOrcamentosJPA implements IRepOrcamentosJPA {
    IRepOrcamentosJPA repJPA;

    public RepOrcamentosJPA(IRepOrcamentosJPA repJPA) {
        this.repJPA = repJPA;
    }

    
}
