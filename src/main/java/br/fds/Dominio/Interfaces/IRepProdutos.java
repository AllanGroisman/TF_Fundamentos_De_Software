package br.fds.Dominio.Interfaces;

import java.util.List;

import br.fds.Dominio.Entidades.Produto;

public interface IRepProdutos {
    void save(Produto p);
    List<Produto> all();
}
