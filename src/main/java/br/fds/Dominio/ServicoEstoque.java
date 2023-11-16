package br.fds.Dominio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fds.Dominio.Entidades.Produto;

@Service
public class ServicoEstoque {
    private IRepProdutos repProd;

    @Autowired
    public ServicoEstoque(IRepProdutos repProd) {
        this.repProd = repProd;
    }

    public List<Produto> prodDisp() {
        return repProd.all();
    }
}
