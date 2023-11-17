package br.fds.Dominio.Servicos;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fds.Dominio.Entidades.Orcamento;
import br.fds.Dominio.Entidades.Pedido;
import br.fds.Dominio.Entidades.Produto;
import br.fds.Dominio.Interfaces.IRepOrcamentos;
import br.fds.Dominio.Interfaces.IRepProdutos;

@Service
public class ServicoVenda {
    private IRepProdutos repProdutos;
    private IRepOrcamentos repOrcamentos;

    @Autowired
    public ServicoVenda(IRepProdutos repProdutos, IRepOrcamentos repOrcamentos) {
        this.repProdutos = repProdutos;
        this.repOrcamentos = repOrcamentos;
    }   

    public Orcamento solicOrcamento(String cliente, Map<Long, Integer> listaProd) {

        //Percorre a lista de produtos pegando os valores * qtd e somando numa variavel total
        double custoTotal = 0;
        for (Map.Entry<Long, Integer> entry : listaProd.entrySet()){
            Produto p = repProdutos.getProduto(entry.getKey());
            custoTotal = p.getPreco() * entry.getValue();
        }
        // cria o pedido com o cliente e a lista
        Pedido pedido = new Pedido(cliente, listaProd);
        //Pega a data do momento
        LocalDate dataAtual = LocalDate.now();
        // cria o orcamento com todas as variaveis
        Orcamento orcamento = new Orcamento(pedido,custoTotal,dataAtual);
        //salva no repositorio
        repOrcamentos.save(orcamento);
        //retorna ele mesmo
        return orcamento;
    }

    public Orcamento getOrcamento(Long orcamento) {
        return repOrcamentos.getOrcamento(orcamento);
    }

    public void efetivarCompra(Map<Long,Integer> listaItens) {
        //para cada produto
        for (Map.Entry<Long, Integer> entry : listaItens.entrySet()) {
            //pega a chave e a qtd
            Long chave = entry.getKey();
            Integer qtdVendida = entry.getValue();
            //acha o produto e o altera
            Produto p = repProdutos.getProduto(chave);
            int qtdAtual =p.getQtd_atual();
            int qtdFinal = qtdAtual - qtdVendida;
            p.setQtd_atual(qtdFinal);

            //atualiza no repositorio
            repProdutos.save(p);            
        }
    }

}
