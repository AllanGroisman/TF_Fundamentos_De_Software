package br.fds.Aplicacao.Estatistica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.Dominio.Entidades.ServicoEstatistica;

@Component
public class Estatistica1_UC {
    @Autowired
    private ServicoEstatistica servicoEstatistica;

    public void run() {
        return servicoEstatistica.estatistica1();
    }
}
