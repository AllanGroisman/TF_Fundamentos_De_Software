package br.fds.Persistencia.Orcamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.fds.Dominio.IRepOrcamentos;
import br.fds.Dominio.Entidades.Orcamento;

@Repository
@Primary
public class RepOrcamentosJPA implements IRepOrcamentos {
    IRepOrcamentosJPA repJPA;

    @Autowired
    public RepOrcamentosJPA(IRepOrcamentosJPA repJPA) {
        this.repJPA = repJPA;
    }

    @Override
    public void save(Orcamento orcamento) {
       repJPA.save(orcamento);
    }

    
}
