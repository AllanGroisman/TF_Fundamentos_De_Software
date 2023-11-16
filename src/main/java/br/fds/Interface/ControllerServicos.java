package br.fds.Interface;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fds.Aplicacao.Servico.BuscaProdDisponivel_UC;

import br.fds.Dominio.Entidades.Produto;

@RestController
@RequestMapping("/servicos")
public class ControllerServicos {
    BuscaProdDisponivel_UC buscaProdDisponivel_UC;
    

    // Construtora
    @Autowired
    public ControllerServicos(BuscaProdDisponivel_UC buscaProdDisponivel_UC) {
        this.buscaProdDisponivel_UC = buscaProdDisponivel_UC;
        
        System.out.println("\n\nCriado Controller Serviços\n\n");
    }

    // Entrada padrão
    @GetMapping("/")
    @CrossOrigin(origins = "*")
    public String inicioServicos() {
        return "Serviços do Sistema";
    }

    // BUSCAR PRODUTOS DISPONIVEIS
    @GetMapping("/produtos")
    @CrossOrigin("*")
    // Solicitar BuscaProdDisponivel
    public List<Produto> buscaProdDisp() {
        return buscaProdDisponivel_UC.run();
    }

    // // REQUERIR ORCAMENTO
    // @GetMapping("/orcamento/{cliente}/{produto}/{quantidade}")
    // @CrossOrigin("*")
    // // Solicitar orcamento
    // public Orcamento solicitarOrcamento(@PathVariable("cliente") String cliente,
    //         @PathVariable("produto") String produto, @PathVariable("quantidade") String quantidade) {
    //     Map<Long, Integer> listaProd = new HashMap<Long, Integer>();
    //     listaProd.put(Long.parseLong(produto), Integer.parseInt(quantidade));
    //     return solicOrcamento_UC.run(cliente, listaProd);
    // }

    // // EFETIVAR ORCAMENTO
    // @GetMapping("/efetivarCompra/{orcamento}")
    // @CrossOrigin("*")
    // // Solicitar efetivar compra
    // public String efetivarCompra(@PathVariable("orcamento") String orcamento) {
    //     boolean efetivacao = efetivarCompra_UC.run(Integer.parseInt(orcamento));

    //     if (efetivacao) {
    //         return "Compra Efetivada";
    //     }
    //     return "Compra Não Efetivada";
    // }

}
