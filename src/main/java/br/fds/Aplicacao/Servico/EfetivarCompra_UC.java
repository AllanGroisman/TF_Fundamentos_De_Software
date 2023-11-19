package br.fds.Aplicacao.Servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.Dominio.Servicos.ServicoVenda;

@Component
public class EfetivarCompra_UC {

    @Autowired
    private ServicoVenda servicoVenda;

    public String run(Long orcamento) {
        
        // Se for viavel, executa e retorna qe é viavel
        if (servicoVenda.efetivarCompra(orcamento)) {
            return "Compra Efetivada";
        }
        // se nao apenas retorna nao viavel
        return "Compra não Efetivada";
    }

}
