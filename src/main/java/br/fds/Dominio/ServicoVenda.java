package br.fds.Dominio;

//import java.util.ArrayList;
//import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fds.Dominio.Entidades.Orcamento;
import br.fds.Dominio.Entidades.Pedido;
//import br.fds.Dominio.Entidades.Produto;

@Service
public class ServicoVenda {
    //private IRepProdutos repProdutos;
    private IRepOrcamentos repOrcamentos;

    @Autowired
    public ServicoVenda(IRepProdutos repProdutos, IRepOrcamentos repOrcamentos) {
        //this.repProdutos = repProdutos;
        this.repOrcamentos = repOrcamentos;
    }

    // public boolean efetivarCompra(Integer orcamento) {
    //     // acha o orcamento no repositorio
    //     Orcamento orcamentoAux = repOrcamentos.getOrcamento(orcamento);

    //     // acha o pedido a partir do orcamento
    //     Pedido pedido = orcamentoAux.getPedido();

    //     // pega a lista de itens (produto,quantidade) a partir do pedido
    //     Map<Long, Integer> listaItens = pedido.getListaProd();

    //     // Altera no repositorio as quantidades
    //     //para cada produto (chave)
    //     listaItens.forEach((chave, valor) -> {
    //         //pega o produto
    //         Produto produto = repProdutos.findById(chave);

    //         //altera q qtd atual dele
    //         produto.setQtdAtual(valor);

    //         //atualiza no banco de dados
    //         repProdutos.merge(produto);
    //     });
    //     return true;
    // }

    public Orcamento solicOrcamento(String cliente, Map<Long, Integer> listaProd) {

        // cria o pedido com o cliente e a lista
        Pedido pedido = new Pedido(cliente, listaProd);

        // cria o orcamento a partir do pedido
        Orcamento orcamento = new Orcamento(pedido);
        //salva no repositorio
        repOrcamentos.save(orcamento);
        //retorna ele mesmo
        return orcamento;
    }

    // public List<Produto> getProdutosOrcamento(Integer orcamento) {
    //     // Puxa o orcamento do repositorio
    //     Orcamento orcamentoAux = repOrcamentos.getOrcamento(orcamento);
    //     // puxa a lista do pedido do orcamento
    //     Map<Long, Integer> listaPedido = orcamentoAux.getListaPedido();
    //     ArrayList<Produto> listaProdutos = new ArrayList<>();
    //     listaPedido.forEach((chave, valor) -> {
    //         Produto produto = repProdutos.findById(chave);
    //         listaProdutos.add(produto);
    //     });
    //     return listaProdutos;
    // }

}
