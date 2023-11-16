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

    public boolean run(Integer orcamento) {
        //Listas para verificar disponibilidade de compra
        List<Produto> listaEstoque = servicoEstoque.prodDisp();
        List<Produto> listaOrcamento = servicoVenda.getProdutosOrcamento(orcamento);

        //teste se estao disponiveis
        if(listaEstoque.containsAll(listaOrcamento)){
            //Se estiverem, efetiva a compra pelo servico de compra e retorna true
            servicoVenda.efetivarCompra(orcamento);
            return true;
        }
        //se não só retorna false
        return false;
    }

}
