package br.fds.Aplicacao.Servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.Dominio.ServicoEstoque;
import br.fds.Dominio.ServicoVenda;
import br.fds.Dominio.Entidades.Produto;

@Component
public class EfetivarCompra_UC {
    @Autowired
    private ServicoEstoque servicoEstoque;
    private ServicoVenda servicoVenda;

    public void run() {
        // if(servicoVenda.efetivarCompra() && servicoEstoque.efetivarCompra()){
        //     return true;
        // }        
        // return false;
    }
}
