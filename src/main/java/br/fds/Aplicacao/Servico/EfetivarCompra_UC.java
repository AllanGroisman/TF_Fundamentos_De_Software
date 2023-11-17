package br.fds.Aplicacao.Servico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.Dominio.Entidades.Orcamento;
import br.fds.Dominio.Entidades.Pedido;
import br.fds.Dominio.Entidades.Produto;
import br.fds.Dominio.Servicos.ServicoEstoque;
import br.fds.Dominio.Servicos.ServicoVenda;

@Component
public class EfetivarCompra_UC {
    @Autowired
    private ServicoVenda servicoVenda;
    @Autowired
    private ServicoEstoque servicoEstoque;

    public boolean run(Long orcamento) {

        System.out.println();

        // Lista de produtos
        List<Produto> listaProdutosDisp = servicoEstoque.prodDisp();

        // Cria um Map a partir da lista de produtos para comparar com o map vindo do
        // orcamento
        Map<Long, Integer> mapProdDisp = new HashMap<>();
        for (Produto produto : listaProdutosDisp) {
            int qtdAtual = produto.getQtd_atual();
            int qtdMin = produto.getQtd_min();
            int qtdDisp = qtdAtual - qtdMin;
            mapProdDisp.put(produto.getId(), qtdDisp);
        }

        // Orcamento requerido
        Orcamento orcamentoAux = servicoVenda.getOrcamento(orcamento);
        // Map de id/qtd do orcamento
        Pedido pedidoAux = orcamentoAux.getPedido();
        Map<Long, Integer> mapProdutosOrcamento = pedidoAux.getListaProd();

        boolean viabilidade = true;
        for (Long chave : mapProdutosOrcamento.keySet()) {
            // Se não tiver a chave (não tem o produto disponivel), ja sai do for e nao é
            // viavel
            if (!mapProdDisp.containsKey(chave)) {
                viabilidade = false;
                break;
            }
            int qtdDisp = mapProdDisp.get(chave);
            int qtdReq = mapProdutosOrcamento.get(chave);
            // Se a quantidade daquele produto não é suficiente, ja sai do for e nao é
            // viavel
            if (qtdDisp < qtdReq) {
                viabilidade = false;
                break;
            }
        }

        // Se for viavel, executa e retorna true
        if (viabilidade) {
            System.out.println("É VIAVEL");
            servicoVenda.efetivarCompra(mapProdutosOrcamento);
            System.out.println();
            return true;
        }
        // se nao apenas retorna falso
        System.out.println("NÃO É VIAVEL");
        return false;
    }

}
