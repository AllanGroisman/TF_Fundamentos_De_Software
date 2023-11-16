package br.fds.Persistencia;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.fds.Dominio.IRepOrcamentos;
import br.fds.Dominio.Entidades.Orcamento;

@Repository
@Primary
public class RepOrcamentosJPA implements IRepOrcamentos {
    IRepOrcamentosJPA repJPA;

    public RepOrcamentosJPA(IRepOrcamentosJPA repJPA) {
        this.repJPA = repJPA;
    }

    @Override
    public void save(Orcamento orcamento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Orcamento getOrcamento(Integer orcamento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrcamento'");
    }

    
}
