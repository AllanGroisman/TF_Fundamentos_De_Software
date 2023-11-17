package br.fds.Dominio.Interfaces;

import br.fds.Dominio.Entidades.Orcamento;

public interface IRepOrcamentos {

    void save(Orcamento orcamento);

    Orcamento getOrcamento(Long orcamento);

}
