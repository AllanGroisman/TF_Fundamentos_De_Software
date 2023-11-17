package br.fds.Dominio.Servicos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fds.Dominio.Entidades.Orcamento;
import br.fds.Dominio.Entidades.Produto;
import br.fds.Dominio.Interfaces.IRepOrcamentos;
import br.fds.Dominio.Interfaces.IRepProdutos;

@Service
public class ServicoEstatistica {
    private IRepOrcamentos repOrcamentos;
    private IRepProdutos repProdutos;

    @Autowired
    public ServicoEstatistica(IRepOrcamentos repOrcamentos, IRepProdutos repProdutos) {
        this.repOrcamentos = repOrcamentos;
        this.repProdutos = repProdutos;
    }

    public String orcamentoPosData(LocalDate data) {
        List<Orcamento> todosOrcamentos = repOrcamentos.all();
        List<Orcamento> posData;
        posData = todosOrcamentos.stream()
                .filter(f -> f.getData().isAfter(data))
                .collect(Collectors.toList());

        //return posData.toString();
        //% de orcamentos pos aquela data
        double numeroTotal = todosOrcamentos.size();
        double totalPosData = posData.size();
        double porCentagemTotal = (totalPosData/numeroTotal) * 100;
        
        //% destes que foram efetuados
        List<Orcamento> efetivadosPos = posData.stream()
                        .filter(f->f.getEfetuado())
                        .collect(Collectors.toList());
        double qtdEfetuados = efetivadosPos.size();
        double porCentagemEfetuados = (qtdEfetuados/totalPosData)*100;

        String resposta = "Foram efetuados " + numeroTotal + " orcamentos.\n" + 
                "Destes, " + totalPosData + " (" + porCentagemTotal + ") foram feitos após a data " + data.toString() + "\n" +
                "Dos orcamentos pós data, foram realmente efetuados " + qtdEfetuados+ " (" + porCentagemEfetuados + ")";
        
        return resposta;
    }

    public String principaisClientes() {
        Map<String, List<Orcamento>> listaClientes = new HashMap<>();
        List<Orcamento> todosOrcamentos = repOrcamentos.all();
        for (Orcamento orcamento : todosOrcamentos) {
            String cliente = orcamento.getCliente();

            if (listaClientes.containsKey(cliente)) {
                listaClientes.get(cliente).add(orcamento);
            } else {
                List<Orcamento> novoOrcamento = new ArrayList<>();
                novoOrcamento.add(orcamento);
                listaClientes.put(cliente, novoOrcamento);
            }
        }

        //Cliente com mais compras
        String clienteMaisCompras = "";
        int numCompras = 0;
        //Cliente que mais gastou
        String clienteMaisGastou = "";
        double valorGasto = 0;

        //For passando pelos clientes
        for (Map.Entry<String, List<Orcamento>> entry : listaClientes.entrySet()){

            //maior quantidade
            int numComprasAux = entry.getValue().size();
            if(numComprasAux>numCompras){
                numCompras = numComprasAux;
                clienteMaisCompras = entry.getKey();
            }

            //maior valor
            double valorClienteAux = 0;
            for (Orcamento orcamento : entry.getValue()) {
                valorClienteAux += orcamento.getValorTotal();
            }
            if(valorClienteAux>valorGasto){
                valorGasto = valorClienteAux;
                clienteMaisGastou = entry.getKey();
            }

        }

        String resposta = "O Cliente que mais gastou foi: " + clienteMaisGastou + ", que gastou " + valorGasto + ".\n" +
                    "O Cliente que comprou mais vezes comprou foi: " + clienteMaisCompras + ", que comprou " + numCompras + " vezes."; 
        return resposta;
    }

    public String produtosIndisponiveis() {
        List<Produto> todosProdutos = repProdutos.all();
        List<Produto> produtosIndisponiveis;
        produtosIndisponiveis = todosProdutos.stream()
                .filter(f -> (!f.dispProd()))
                .collect(Collectors.toList());

        double totalProdutos = todosProdutos.size();
        double totalIndisp = produtosIndisponiveis.size();
        double porCentagem = (totalIndisp/totalProdutos)*100;

        StringBuilder resposta = new StringBuilder();
        resposta.append("De um total de " + totalProdutos + " produtos, " + totalIndisp +
                         " (" + porCentagem + "%) estao indisponiveis\n");
        
        resposta.append("Os produtos indisponiveis são:\n");
        for (Produto produto : produtosIndisponiveis) {
            resposta.append(produto.toString());
        }

        return resposta.toString();
    }

}
