package br.fds.Dominio.Desconto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.fds.Dominio.Entidades.Orcamento;

// Fábrica de políticas de desconto
public class FabricaDesconto {
    public double criarPoliticaDesconto(List<Orcamento> ultimasCompras) {
        // return 0.5;

        // Calcula todos os descontos
        IPoliticaDesconto politicaMaisDez = new PoliticaMaisDez();
        IPoliticaDesconto politicaMedia = new PoliticaMedia();

        // Cria uma lista e adiciona os descontos de cada politica
        List<Double> listaDescontos = new ArrayList<>();
        listaDescontos.add(politicaMaisDez.getDesconto(ultimasCompras));
        listaDescontos.add(politicaMedia.getDesconto(ultimasCompras));

        // Pega o maior desconto e o retorna
        double maiorValor = Collections.max(listaDescontos);
        return maiorValor;
    }
}
