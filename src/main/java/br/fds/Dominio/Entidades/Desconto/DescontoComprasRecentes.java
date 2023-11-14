package br.fds.Dominio.Entidades.Desconto;

public class DescontoComprasRecentes implements IDesconto {

    @Override
    public double calcularDesconto(String cliente, double valorCompra) {
        int numCompras = 20; //pegar numero de compras
        if (numCompras > 10)
        {
            return 0.25;
        }
        return 0;
    }
    
}
