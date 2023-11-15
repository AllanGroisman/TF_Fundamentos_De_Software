package br.fds.Persistencia;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.fds.Dominio.IRepOrcamentos;

@Repository
@Primary
public class RepOrcamentosJPA implements IRepOrcamentos {
    IRepOrcamentosJPA repJPA;

    public RepOrcamentosJPA(IRepOrcamentosJPA repJPA) {
        this.repJPA = repJPA;
    }

    
}
