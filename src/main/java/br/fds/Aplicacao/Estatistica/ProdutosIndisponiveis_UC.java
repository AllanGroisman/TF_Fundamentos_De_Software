package br.fds.Aplicacao.Estatistica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.Dominio.Servicos.ServicoEstatistica;

@Component
public class ProdutosIndisponiveis_UC {

    @Autowired
    private ServicoEstatistica servicoEstatistica;

    public String run() {
        return servicoEstatistica.produtosIndisponiveis();
    }
    
}
