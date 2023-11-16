package br.fds.Dominio;

import br.fds.Dominio.Entidades.Orcamento;

public interface IRepOrcamentos {

    void save(Orcamento orcamento);

    Orcamento getOrcamento(Integer orcamento);
    
}
