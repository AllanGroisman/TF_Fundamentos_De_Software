package br.fds.Aplicacao.Servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.Dominio.ServicoEstatistica;
import br.fds.Dominio.ServicoEstoque;
import br.fds.Dominio.Entidades.Produto;

@Component
public class BuscaProdDisponivel_UC {
    @Autowired
    private ServicoEstoque servicoEstoque;

    public void run() {
        //return servicoEstoque.prodDisp();
    }

}
