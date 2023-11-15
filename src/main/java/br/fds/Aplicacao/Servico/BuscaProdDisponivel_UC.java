package br.fds.Aplicacao.Servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.Dominio.Entidades.ServicoEstatistica;
import br.fds.Dominio.Entidades.ServicoEstoque;
import br.fds.Dominio.Entidades.Entidades.Produto;

@Component
public class BuscaProdDisponivel_UC {
    @Autowired
    private ServicoEstoque servicoEstoque;

    public List<Produto> run() {
        return servicoEstoque.prodDisp();
    }

}
