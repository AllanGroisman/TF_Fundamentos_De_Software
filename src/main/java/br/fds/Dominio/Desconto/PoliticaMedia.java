package br.fds.Dominio.Desconto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.fds.Dominio.Entidades.Orcamento;

//Pega a media dos ultimos 3 compras - 10% acima de 10.000 + 5% para cada 10.000 até 30%
public class PoliticaMedia implements IPoliticaDesconto {
    @Override
    public double getDesconto(List<Orcamento> ultimasCompras) {

        //Ordena pelos mais recentes
        ultimasCompras.sort(Comparator.comparing(Orcamento::getData).reversed());

        // Pegar as últimas três compras
        List<Orcamento> ultimasTresCompras = ultimasCompras.stream()
                .limit(3)
                .collect(Collectors.toList());

        // Calcular a média dos valores das últimas três compras
        double media = ultimasTresCompras.stream()
                .mapToDouble(Orcamento::getValorTotal)
                .average()
                .orElse(0.0);

        // desconto comeca como 0
        double desconto = 0.0;
        //se for mais que 10k acrescenta desconto
        if (media > 10000) {
            desconto += 0.10; // 10% de desconto se for acima de 10.000

            // Adicionar 5% para cada 10.000 até 30%
            double excedente = Math.max(0, media - 10000); // Pega o valor acima dos 10k
            desconto += Math.min(excedente / 10000 * 0.05, 0.30); // Soma ate o maximo de 30% 
        }
        //retorna o desconto
        return desconto; 
    }
}
