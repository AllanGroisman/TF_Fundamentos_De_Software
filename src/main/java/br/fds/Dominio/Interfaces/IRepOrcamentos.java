package br.fds.Dominio.Interfaces;

import java.util.List;

import br.fds.Dominio.Entidades.Orcamento;

public interface IRepOrcamentos {

    void save(Orcamento orcamento);

    Orcamento getOrcamento(Long orcamento);

    List<Orcamento> getHistorico(String cliente);

    List<Orcamento> all();

}
