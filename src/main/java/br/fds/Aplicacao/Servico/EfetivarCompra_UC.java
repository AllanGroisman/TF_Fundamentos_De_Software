package br.fds.Aplicacao.Servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.Dominio.Entidades.ServicoEstoque;
import br.fds.Dominio.Entidades.ServicoVenda;
import br.fds.Dominio.Entidades.Entidades.Produto;

@Component
public class EfetivarCompra_UC {
    @Autowired
    private ServicoEstoque servicoEstoque;
    private ServicoVenda servicoVenda;

    public boolean run() {
        if(servicoVenda.efetivarCompra() && servicoEstoque.efetivarCompra()){
            return true;
        }        
        return false;
    }
}
