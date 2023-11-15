package br.fds.Dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoEstatistica {
    private IRepEstoque repEstoque;
    private IRepOrcamentos repOrcamentos;
    private IRepProdutos repProdutos;

    @Autowired
    public ServicoEstatistica(IRepEstoque repEstoque, IRepOrcamentos repOrcamentos, IRepProdutos repProdutos) {
        this.repEstoque = repEstoque;
        this.repOrcamentos = repOrcamentos;
        this.repProdutos = repProdutos;
    }

    

    
}
