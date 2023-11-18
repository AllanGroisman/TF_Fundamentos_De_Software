package br.fds.Dominio.Desconto;

import java.util.List;
import br.fds.Dominio.Entidades.Orcamento;

//Pega a media dos ultimos 3 compras - 10% acima de 10.000 + 5% para cada 10.000 até 30%
public class PoliticaMedia implements IPoliticaDesconto {
    @Override
    public double getDesconto(List<Orcamento> ultimasCompras) {
    System.out.println("\n\n\nTESTE");
        int aux = ultimasCompras.size(); // Pega a ultima posicao
        // Se tiver menos de 3 itens, retorna 0 na hora
        if (aux < 3) {
            return 0.0;
        }
        // Calcular a média dos valores das últimas três compras
        double valorCompra1 = ultimasCompras.get(aux - 1).getValorTotal();
        double valorCompra2 = ultimasCompras.get(aux - 2).getValorTotal();
        double valorCompra3 = ultimasCompras.get(aux - 3).getValorTotal();
        double media = (valorCompra1 + valorCompra2 + valorCompra3) / 3;

        System.out.println("\n\n\n" + valorCompra1 + " " + valorCompra2 + " " + valorCompra3 + " media: " + media);

        double desconto = 0.0;
        if (media > 10000) {
            desconto = 0.1;
            double excedente = media - 10000;
        
            while (excedente >= 10000 && desconto < 0.3) {
                desconto += 0.05;
                excedente -= 10000;
            }
        }
        return desconto;
        
    }
}
