package br.fds.Aplicacao.Servico;

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

    public boolean run(Long orcamento) {

        System.out.println();


        // Lista de produtos
        System.out.println("List<Produto> listaProdutosDisp = servicoEstoque.prodDisp();");
        List<Produto> listaProdutosDisp = servicoEstoque.prodDisp();
        // Orcamento requerido
        System.out.println("Orcamento orcamentoAux = servicoVenda.getOrcamento(orcamento);");
        Orcamento orcamentoAux = servicoVenda.getOrcamento(orcamento);
        // Map de id/qtd do orcamento
        System.out.println("Map<Long, Integer> mapProdutosOrcamento = orcamentoAux.getListaPedido();");
        Map<Long, Integer> mapProdutosOrcamento = orcamentoAux.getListaPedido();

        boolean viabilidade = true;
        // para cada produto disponivel
        for (Produto p : listaProdutosDisp) {
            System.out.println("Long idProduto = p.getId();");
            Long idProduto = p.getId();
            System.out.println(p);
            // se tem algum do map do orcamento
            System.out.println("mapProdutosOrcamento.containsKey(idProduto)");
            if (mapProdutosOrcamento.containsKey(idProduto)) {
                //compara as quantidades
                System.out.println("int qtdAtual = p.getQtd_atual();");
                int qtdAtual = p.getQtd_atual();
                System.out.println("int qtdVendida = mapProdutosOrcamento.get(idProduto);");
                int qtdVendida = mapProdutosOrcamento.get(idProduto);
                //se não tiver qtd de um elemento, logo nao da pra efetivar a compra
                System.out.println("qtdAtual < qtdVendida");
                if (qtdAtual < qtdVendida) {
                    viabilidade = false;
                    break;
                }

            } else {
                // nao tem algum dos elementos, logo nao da pra efetivar a compra
                viabilidade = false;
                break;
            }

        }
        //Se for viavel, executa e retorna true
        if (viabilidade) {
            System.out.println("List<Produto> listaProdutosDisp = servicoEstoque.prodDisp();");
            servicoVenda.efetivarCompra(mapProdutosOrcamento);
            System.out.println();
            return true;
        }
        //se nao apenas retorna falso
        System.out.println();
        return false;
    }

}
