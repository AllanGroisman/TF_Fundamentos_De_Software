package br.fds.Persistencia;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.fds.Dominio.Entidades.Produto;

public interface IRepProdutosJPA extends CrudRepository<Produto,Long> {
    List<Produto> findAll();
}
