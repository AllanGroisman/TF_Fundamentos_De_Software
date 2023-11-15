package br.fds.Persistencia;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.fds.Dominio.Entidades.Estoque;

public interface IRepEstoqueJPA extends CrudRepository<Estoque,Long> {
    List<Estoque> findAll();
    
}
