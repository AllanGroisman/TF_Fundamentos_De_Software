package br.fds.Aplicacao.Estatistica;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.Dominio.Entidades.Orcamento;
import br.fds.Dominio.Servicos.ServicoEstatistica;

@Component
public class PrincipaisClientes_UC {
    
    @Autowired
    private ServicoEstatistica servicoEstatistica;

    public Map<String,List<Orcamento>> run() {
        return servicoEstatistica.principaisClientes();
    }
    
}
