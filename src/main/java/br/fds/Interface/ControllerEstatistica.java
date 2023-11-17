package br.fds.Interface;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fds.Aplicacao.Estatistica.OrcamentosPosData_UC;
import br.fds.Aplicacao.Estatistica.PrincipaisClientes_UC;
import br.fds.Aplicacao.Estatistica.ProdutosIndisponiveis_UC;
import br.fds.Dominio.Entidades.Orcamento;
import br.fds.Dominio.Entidades.Produto;

@RestController
@RequestMapping("/estatisticas")
public class ControllerEstatistica {
    private OrcamentosPosData_UC orcamentosPosData_UC;
    private PrincipaisClientes_UC principaisClientes_UC;
    private ProdutosIndisponiveis_UC produtosIndisponiveis_UC;

    // Construtor
    @Autowired

    // Entrada padrão
    @GetMapping("/")
    @CrossOrigin(origins = "*")
    public String inicioServicos() {
        
        return "Estatisticas do Sistema " + LocalDate.now();
    }

    public ControllerEstatistica(OrcamentosPosData_UC orcamentosPosData_UC, PrincipaisClientes_UC principaisClientes_UC,
            ProdutosIndisponiveis_UC produtosIndisponiveis_UC) {
        this.orcamentosPosData_UC = orcamentosPosData_UC;
        this.principaisClientes_UC = principaisClientes_UC;
        this.produtosIndisponiveis_UC = produtosIndisponiveis_UC;

        System.out.println("\n\nCriado Controller Estatistico\n\n");
    }

    // Quais sao os orcamentos efetuados a partir de tal data
    @GetMapping("/orcamentosPosData/{data}")
    @CrossOrigin("*")
    public String orcamentosPosData(@PathVariable("data") String data) {
        LocalDate dataFormatado = LocalDate.parse(data);
        return orcamentosPosData_UC.run(dataFormatado);

    }

    // 3 Principais Clientes
    @GetMapping("/principaisClientes/")
    @CrossOrigin("*")
    public String principaisClientes() {
        return principaisClientes_UC.run();
    }

    // Produtos que estao abaixo do minimo
    @GetMapping("/produtosIndisponiveis/")
    @CrossOrigin("*")
    public String produtosIndisponiveis() {
        return produtosIndisponiveis_UC.run();
    }

}
