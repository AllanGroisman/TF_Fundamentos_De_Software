package br.fds.Interface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fds.Aplicacao.Servico.BuscaProdDisponivel_UC;
import br.fds.Aplicacao.Servico.EfetivarCompra_UC;
import br.fds.Aplicacao.Servico.SolicOrcamento_UC;
import br.fds.Dominio.Entidades.Produto;

@RestController
@RequestMapping("/servicos")
public class ControllerServicos {
    BuscaProdDisponivel_UC buscaProdDisponivel_UC;
    SolicOrcamento_UC solicOrcamento_UC;
    EfetivarCompra_UC efetivarCompra_UC;

    // Construtora
    @Autowired
    public ControllerServicos(BuscaProdDisponivel_UC buscaProdDisponivel_UC, SolicOrcamento_UC solicOrcamento_UC,
            EfetivarCompra_UC efetivarCompra_UC) {
        this.buscaProdDisponivel_UC = buscaProdDisponivel_UC;
        this.solicOrcamento_UC = solicOrcamento_UC;
        this.efetivarCompra_UC = efetivarCompra_UC;

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

    // REQUERIR ORCAMENTO
    @GetMapping("/orcamento/{cliente}/{produto}/{quantidade}")
    @CrossOrigin("*")
    // Solicitar orcamento (por enquanto com 1)
    public String solicitarOrcamento(@PathVariable("cliente") String cliente,
            @PathVariable("produto") String produtos,
            @PathVariable("quantidade") String quantidades) {
            
        //separa cada prod e cada qtd
        String[] listaProdutos = produtos.split("-");
        String[] listaQuantidades = quantidades.split("-");

        // cria um map com para os juntar os dois
        Map<Long, Integer> mapProd = new HashMap<>();

        // junta todos
        for (int i = 0; i < listaProdutos.length; i++) {
            mapProd.put(Long.parseLong(listaProdutos[i]), Integer.parseInt(listaQuantidades[i]));
        }
        
        return solicOrcamento_UC.run(cliente, mapProd).toString();

    }

    // EFETIVAR ORCAMENTO
    @GetMapping("/efetivarCompra/{orcamento}")
    @CrossOrigin("*")
    // Efetivar compra do orcamento x
    public String efetivarCompra(@PathVariable("orcamento") Long orcamento) {
        // Transforma em long e chama o metodo
        String efetivacao = efetivarCompra_UC.run(orcamento);
        return efetivacao;
    }
}
