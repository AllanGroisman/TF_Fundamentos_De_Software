package br.fds;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.fds.Dominio.Desconto.FabricaDesconto;
import br.fds.Dominio.Entidades.Orcamento;
import br.fds.Dominio.Entidades.Pedido;



public class FabricaDescontoTest {
    private FabricaDesconto testeFabrica;
    private List<Orcamento> listaOrcamento;

    @BeforeEach
    public void initialize(){
        testeFabrica = new FabricaDesconto();
        listaOrcamento = new ArrayList<>();
    }

    @Test
    public void testSemDesconto(){
        //Lista de produtos, que cria o pedido, que cria o orcamento
        Map<Long,Integer> listaProd = new HashMap<>();
        Pedido pedido = new Pedido("Cliente", listaProd);
        LocalDate data = LocalDate.now();
        Orcamento orcamentoUm = new Orcamento(pedido, 10000, data, 0.0);
        listaOrcamento.add(orcamentoUm);

        double desconto = testeFabrica.criarPoliticaDesconto(listaOrcamento);
        double descontoESperado = 0.0;
        Assertions.assertEquals(descontoESperado,desconto);
    }
    //Teste Média 10%
    @Test
    public void testDescontoMedia(){
        //Lista de produtos, que cria o pedido, que cria o orcamento
        Map<Long,Integer> listaProd = new HashMap<>();
        Pedido pedido = new Pedido("Cliente", listaProd);
        LocalDate data = LocalDate.now();
        Orcamento orcamentoUm = new Orcamento(pedido, 10000, data, 0.0);
        listaOrcamento.add(orcamentoUm);

        Orcamento orcamentoDois = new Orcamento(pedido, 10000, data, 0.0);
        listaOrcamento.add(orcamentoDois);

        Orcamento orcamentoTres = new Orcamento(pedido, 10000, data, 0.0);
        listaOrcamento.add(orcamentoTres);

        double desconto = testeFabrica.criarPoliticaDesconto(listaOrcamento);
        double descontoESperado = 0.1;
        Assertions.assertEquals(descontoESperado,desconto);
    }

    //Teste Média extrapola 30% e fica nos 30
    @Test
    public void testDescontoMedia30(){
        //Lista de produtos, que cria o pedido, que cria o orcamento
        Map<Long,Integer> listaProd = new HashMap<>();
        Pedido pedido = new Pedido("Cliente", listaProd);
        LocalDate data = LocalDate.now();
        Orcamento orcamentoUm = new Orcamento(pedido, 10000000, data, 0.0);
        listaOrcamento.add(orcamentoUm);

        Orcamento orcamentoDois = new Orcamento(pedido, 10000000, data, 0.0);
        listaOrcamento.add(orcamentoDois);

        Orcamento orcamentoTres = new Orcamento(pedido, 10000000, data, 0.0);
        listaOrcamento.add(orcamentoTres);

        double desconto = testeFabrica.criarPoliticaDesconto(listaOrcamento);
        double descontoESperado = 0.3;
        Assertions.assertEquals(descontoESperado,desconto);
    }

    //Teste Dez nos ultimos 6 meses
    @Test
    public void testDescontoDez(){
        //Lista de produtos, que cria o pedido, que cria o orcamento
        Map<Long,Integer> listaProd = new HashMap<>();
        Pedido pedido = new Pedido("Cliente", listaProd);
        LocalDate data = LocalDate.now();

        for (int i = 0; i < 15; i++) {
            listaOrcamento.add(new Orcamento(pedido, 10, data, 0.0));
        }

        double desconto = testeFabrica.criarPoliticaDesconto(listaOrcamento);
        double descontoESperado = 0.25;
        Assertions.assertEquals(descontoESperado,desconto);
    }

    //Teste Dez nos ultimos 6 meses, mas com data antiga é pra ser sem desconto
    @Test
    public void testDescontoDezDataErrada(){
        //Lista de produtos, que cria o pedido, que cria o orcamento
        Map<Long,Integer> listaProd = new HashMap<>();
        Pedido pedido = new Pedido("Cliente", listaProd);
        LocalDate data = LocalDate.of(2020, 1,1);

        for (int i = 0; i < 15; i++) {
            listaOrcamento.add(new Orcamento(pedido, 10, data, 0.0));
        }

        double desconto = testeFabrica.criarPoliticaDesconto(listaOrcamento);
        double descontoESperado = 0.0;
        Assertions.assertEquals(descontoESperado,desconto);
    }



}
