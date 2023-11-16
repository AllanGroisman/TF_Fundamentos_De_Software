package br.fds.Dominio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fds.Dominio.Entidades.Produto;

@Service
public class ServicoEstoque {
    private IRepProdutos repProdutos;

    @Autowired
    public ServicoEstoque(IRepProdutos repProdutos) {
        this.repProdutos = repProdutos;
    }

    public List<Produto> prodDisp() {
        return repProdutos.all();
    }
}
