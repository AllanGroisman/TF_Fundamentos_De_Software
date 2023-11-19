package br.fds.Aplicacao.Servico;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.Dominio.Entidades.Orcamento;
import br.fds.Dominio.Entidades.Produto;
import br.fds.Dominio.Servicos.ServicoEstoque;
import br.fds.Dominio.Servicos.ServicoVenda;

@Component
public class EfetivarCompra_UC {

    @Autowired
    private ServicoVenda servicoVenda;
    @Autowired
    private ServicoEstoque servicoEstoque;

    public String run(Long orcamento) {
        // Pega o Orcamento requerido
        Orcamento orcamentoAux = servicoVenda.getOrcamento(orcamento);

        // se o orcamento ja passou do prazo de validade, só retorna falso e não faz
        // nada
        if (!orcamentoAux.getValidade()) {
            return "Orcamento sem validade";
        }

        // Pega o Map de id/qtd dos produtos do pedido dentro do orcamento
        Map<Long, Integer> mapProdutosOrcamento = orcamentoAux.getListaPedido();

        // Lista de produtos disponiveis
        List<Produto> listaProdutosDisp = servicoEstoque.prodDisp();

        // Cria um Map a partir da lista de produtos para comparar
        Map<Long, Integer> mapProdDisp = new HashMap<>();
        for (Produto produto : listaProdutosDisp) {
            int qtdAtual = produto.getQtd_atual();
            //int qtdMin = produto.getQtd_min();
            int qtdDisp = qtdAtual;
            mapProdDisp.put(produto.getId(), qtdDisp);
        }

        // Testa a viabilidade da venda
        boolean viabilidade = true;
        // Para cada produto

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

        // Se for viavel, executa e retorna qe é viavel
        if (viabilidade) {
            servicoVenda.efetivarCompra(orcamentoAux);
            return "Compra Efetivada";
        }
        // se nao apenas retorna nao viavel
        return "Compra não Efetivada";
    }

}
