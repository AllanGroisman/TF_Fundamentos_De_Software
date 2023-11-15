package br.fds.Interface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import br.fds.Aplicacao.Servico.BuscaProdDisponivel_UC;
import br.fds.Aplicacao.Servico.EfetivarCompra_UC;
import br.fds.Aplicacao.Servico.SolicOrcamento_UC;

public class ControllerServicos {
    BuscaProdDisponivel_UC buscaProdDisponivel_UC;
    EfetivarCompra_UC efetivarCompra_UC;
    SolicOrcamento_UC solicOrcamento_UC;

    // Construtora
    @Autowired
    public ControllerServicos(BuscaProdDisponivel_UC buscaProdDisponivel_UC, EfetivarCompra_UC efetivarCompra_UC,
            SolicOrcamento_UC solicOrcamento_UC) {
        this.buscaProdDisponivel_UC = buscaProdDisponivel_UC;
        this.efetivarCompra_UC = efetivarCompra_UC;
        this.solicOrcamento_UC = solicOrcamento_UC;
    }

    @GetMapping("/produtos")
    @CrossOrigin("*")
    // Solicitar BuscaProdDisponivel
    public String buscaProdDisp() {
        return "buscaProdDisp";
    }

    @GetMapping("/compra")
    @CrossOrigin("*")
    // Solicitar efetivar compra
    public String efetivarCompra() {
        return "efetivar compra";
    }

    @GetMapping("/orcamento")
    @CrossOrigin("*")
    // Solicitar orcamento
    public String solicitarOrcamento() {
        return "solicitar orcamento";
    }

}
