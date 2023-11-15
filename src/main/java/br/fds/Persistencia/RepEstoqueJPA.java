package br.fds.Persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.fds.Dominio.IRepEstoque;
import br.fds.Dominio.Entidades.Estoque;

@Repository
@Primary
public class RepEstoqueJPA implements IRepEstoque {
    IRepEstoqueJPA repJPA;

    @Autowired
    public RepEstoqueJPA(IRepEstoqueJPA repJPA) {
        this.repJPA = repJPA;
    }

    @Override
    public List<Estoque> all() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'all'");
    }

    @Override
    public Estoque getEstoque(String nome) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEstoque'");
    }

    
}
