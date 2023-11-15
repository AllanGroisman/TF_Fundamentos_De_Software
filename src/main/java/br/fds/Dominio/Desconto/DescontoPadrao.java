package br.fds.Dominio.Desconto;

public class DescontoPadrao implements IDesconto {

    @Override
    public double calcularDesconto(String cliente, double valorCompra) {
        
        //Pedido pedido;
        //if(pedido.getListaProd().size()>5){return 0.05;}
        return 0.0;
    }
    
}
