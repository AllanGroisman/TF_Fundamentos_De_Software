package br.fds.Aplicacao.Servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.Dominio.Entidades.Produto;
import br.fds.Dominio.Servicos.ServicoEstoque;

@Component
public class BuscaProdDisponivel_UC {
    @Autowired
    private ServicoEstoque servicoEstoque;

    public List<Produto> run() {
        return servicoEstoque.prodDisp();
    }

}
