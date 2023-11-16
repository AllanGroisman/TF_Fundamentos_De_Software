package br.fds.Persistencia;

import br.fds.Dominio.IRepProdutos;
import br.fds.Dominio.Entidades.Produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class RepProdutosJPA implements IRepProdutos {
    IRepProdutosJPA repJPA;

     @Autowired
    public RepProdutosJPA(IRepProdutosJPA repJPA) {
        this.repJPA = repJPA;
    }

    @Override
    public void save(Produto p) {
        repJPA.save(p);
    }

    @Override
    public List<Produto> all() {
        return repJPA.findAll();
    }

   

    


    
}
