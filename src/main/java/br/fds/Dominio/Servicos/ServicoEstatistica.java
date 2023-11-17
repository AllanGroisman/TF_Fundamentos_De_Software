package br.fds.Dominio.Servicos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public List<Orcamento> orcamentoPosData(LocalDate data) {
        List<Orcamento> todosOrcamentos = repOrcamentos.all();
        List<Orcamento> posData;
        posData = todosOrcamentos.stream()
                .filter(f -> f.getData().isAfter(data))
                .collect(Collectors.toList());
        return posData;
    }

    public Map<String, List<Orcamento>> principaisClientes() {
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
        return listaClientes;
    }

    public List<Produto> produtosIndisponiveis() {
        List<Produto> todosProdutos = repProdutos.all();
        List<Produto> produtosIndisponiveis;
        produtosIndisponiveis = todosProdutos.stream()
                .filter(f -> (!f.dispProd()))
                .collect(Collectors.toList());
        return produtosIndisponiveis;
    }

}
