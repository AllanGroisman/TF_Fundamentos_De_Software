package br.fds.Aplicacao.Servico;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.Dominio.ServicoVenda;
import br.fds.Dominio.Entidades.Orcamento;

@Component
public class SolicOrcamento_UC {
    @Autowired
    private ServicoVenda servicoVenda;

    public Orcamento run(String cliente,Map<Long,Integer> listaProd) {
        return servicoVenda.solicOrcamento(cliente,listaProd);
    }
}
