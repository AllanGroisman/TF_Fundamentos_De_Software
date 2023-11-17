package br.fds.Dominio.Desconto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.fds.Dominio.Entidades.Orcamento;

// Fábrica de políticas de desconto
public class FabricaDesconto {
    public double criarPoliticaDesconto(List<Orcamento> ultimasCompras) {
        //Calcula todos os descontos
        IPoliticaDesconto politica1 = new PoliticaMaisDez();
        IPoliticaDesconto politica2 = new PoliticaMedia();

        //Cria uma lista e adiciona os descontos de cada politica
        List<Double> listaDescontos = new ArrayList<>();
        listaDescontos.add(politica1.getDesconto(ultimasCompras));
        listaDescontos.add(politica2.getDesconto(ultimasCompras));
        
        //Pega o maior desconto e o retorna
        double maiorValor = Collections.max(listaDescontos);
        return maiorValor;
    }
}
