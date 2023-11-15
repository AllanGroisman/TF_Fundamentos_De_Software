package br.fds.Persistencia;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.fds.Dominio.Entidades.Orcamento;

public interface IRepOrcamentosJPA extends CrudRepository<Orcamento,Long> {
    List<Orcamento> findAll();
}
