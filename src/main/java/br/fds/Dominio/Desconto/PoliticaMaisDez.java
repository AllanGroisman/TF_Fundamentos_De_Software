package br.fds.Dominio.Desconto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.fds.Dominio.Entidades.Orcamento;

//Acima de 10k 10% e mais 5% para cada 10k ate 30%
public class PoliticaMaisDez implements IPoliticaDesconto {

    @Override
    public double getDesconto(List<Orcamento> ultimasCompras) {
        //return 0.30;
        //Pega o dia atual
        LocalDate dataAtual = LocalDate.now();
        //Tira 6 meses para pegar a data de 6 meses atras
        LocalDate dataSeisMesesAtras = dataAtual.minusMonths(6);
        //Filtra uma nova lista apenas com os dos ultimos seis meses
        List<Orcamento> orcamentosUltimosSeisMeses = ultimasCompras.stream()
                .filter(orcamento -> orcamento.getData().isAfter(dataSeisMesesAtras))
                .collect(Collectors.toList());

        //se tiver mais 10 orcamentos nos ultimos 6 meses retorna 25% de desconto
        if(orcamentosUltimosSeisMeses.size() > 10){
            return 0.25;
        }
        //se não retorna 0%
        return 0.0;
    }

   
}
