package br.fds.Dominio.Entidades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fds.Dominio.Entidades.Entidades.Produto;

@Service
public class ServicoEstoque {
    private IRepEstoque repEstoque;

    @Autowired
    public ServicoEstoque(IRepEstoque repEstoque) {
        this.repEstoque = repEstoque;
    }
   

}
