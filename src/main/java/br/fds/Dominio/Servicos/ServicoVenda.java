package br.fds.Dominio.Servicos;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fds.Dominio.Desconto.FabricaDesconto;
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

        //Calcula o desconto daquele cliente
        //Cria a fabrica
        FabricaDesconto fabricaDesconto = new FabricaDesconto();
        //Pega o historico do cliente e filtra apenas pelos efetuados
        List<Orcamento> historicoCliente = repOrcamentos.getHistorico(cliente).stream()
                            .filter(f->f.getEfetuado()).collect(Collectors.toList());
        //calcula o desconto em cima do historico
        Double desconto = fabricaDesconto.criarPoliticaDesconto(historicoCliente);

        // cria o orcamento com todas as variaveis
        Orcamento orcamento = new Orcamento(pedido,custoTotal,dataAtual,desconto);

        //salva no repositorio
        repOrcamentos.save(orcamento);
        
        //retorna ele mesmo
        return orcamento;
    }

    public boolean efetivarCompra(Long idOrcamento) {
        //pega o orcamento
        Orcamento orcamentoAux = repOrcamentos.getOrcamento(idOrcamento);

        //se le ja foi efetuado, nao efetua
        if(orcamentoAux.getEfetuado()){
            return false;
        }
        //se ele ta fora do prazo de validade, nao efetua
        if(!orcamentoAux.getValidade()){ 
            return false;
        }

        //pega o map de produtos do orcamento
        Map<Long, Integer> listaItens = orcamentoAux.getListaPedido();

        //pega a lista de prod disponiveis no catalogo
        List<Produto> produtosDisponiveis = repProdutos.all().stream()
        .filter(Produto::dispProd) // Filtrando os produtos com disponibilidade true
        .collect(Collectors.toList());
        
        // Cria um Map a partir da lista de produtos disponiveis para comparar
        Map<Long, Integer> mapProdDisp = new HashMap<>();
        for (Produto produto : produtosDisponiveis) {
            int qtdAtual = produto.getQtd_atual();
            //int qtdMin = produto.getQtd_min();
            int qtdDisp = qtdAtual;
            mapProdDisp.put(produto.getId(), qtdDisp);
        }
        
        //compara os dois
        for (Long chave : listaItens.keySet()) {
            // Se não tiver a chave (não tem o produto disponivel), ja sai do for e nao é
            // viavel
            if (!mapProdDisp.containsKey(chave)) {
                return false;
            }
            int qtdDisp = mapProdDisp.get(chave);
            int qtdReq = listaItens.get(chave);
            // Se a quantidade daquele produto não é suficiente, ja sai do for e nao é
            // viavel
            if (qtdDisp < qtdReq) {
                return false;
            }
        }

        //EFETUA A COMPRA DE FATO
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
    
            //atualiza o produo no repositorio
            repProdutos.save(p);            
        }
        //atualiza o orcamento como efetuado
        orcamentoAux.setEfetuado(true);
        repOrcamentos.save(orcamentoAux);
        return true;
    }

}
