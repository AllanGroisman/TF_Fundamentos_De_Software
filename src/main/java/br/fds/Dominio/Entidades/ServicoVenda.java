package br.fds.Dominio.Entidades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoVenda {
    private IRepProdutos repProdutos;
    private IRepOrcamentos repOrcamentos;

    @Autowired
    public ServicoVenda(IRepProdutos repProdutos, IRepOrcamentos repOrcamentos) {
        this.repProdutos = repProdutos;
        this.repOrcamentos = repOrcamentos;
    }
    
}
