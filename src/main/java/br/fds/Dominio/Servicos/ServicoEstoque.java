package br.fds.Dominio.Servicos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fds.Dominio.Entidades.Produto;
import br.fds.Dominio.Interfaces.IRepProdutos;

@Service
public class ServicoEstoque {
    private IRepProdutos repProdutos;

    @Autowired
    public ServicoEstoque(IRepProdutos repProdutos) {
        this.repProdutos = repProdutos;
    }

    public List<Produto> prodDisp() {
        List<Produto> produtosDisponiveis = repProdutos.all().stream()
                .filter(Produto::disponibilidade) // Filtrando os produtos com disponibilidade true
                .collect(Collectors.toList());
        return produtosDisponiveis;
    }

}
