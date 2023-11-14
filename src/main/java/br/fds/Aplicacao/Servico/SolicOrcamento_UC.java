package br.fds.Aplicacao.Servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.Dominio.Entidades.ServicoEstoque;
import br.fds.Dominio.Entidades.ServicoVenda;
import br.fds.Dominio.Entidades.Entidades.Orcamento;
import br.fds.Dominio.Entidades.Entidades.Produto;

@Component
public class SolicOrcamento_UC {
    @Autowired
    private ServicoVenda servicoVenda;

    public Orcamento run() {
        return servicoVenda.solicOrcamento();
    }
}
