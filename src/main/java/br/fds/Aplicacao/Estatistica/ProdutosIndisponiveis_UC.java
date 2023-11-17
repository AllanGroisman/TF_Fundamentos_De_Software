package br.fds.Aplicacao.Estatistica;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.Dominio.Entidades.Produto;
import br.fds.Dominio.Servicos.ServicoEstatistica;

@Component
public class ProdutosIndisponiveis_UC {

    @Autowired
    private ServicoEstatistica servicoEstatistica;

    public List<Produto> run() {
        return servicoEstatistica.produtosIndisponiveis();
    }
    
}
