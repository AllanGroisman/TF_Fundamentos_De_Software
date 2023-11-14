package br.fds.Dominio.Entidades.Desconto;

public class DescontoValorMedio implements IDesconto {

    @Override
    public double calcularDesconto(String cliente, double valorCompra) {
        double valorMedio = 20.00; // aqui vai a media do cliente

        double desconto = 0;
        // se é maior que 10k, 10%
        if (valorMedio > 10000) {
            desconto += 0.1;

            double aux = valorMedio - 10000;
            desconto += Math.min(aux / 1000 * 0.05, 0.3);
        }
        return desconto;

    }

}
