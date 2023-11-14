package br.fds.Dominio.Entidades.Desconto;

import br.fds.Dominio.Entidades.Entidades.Pedido;
import br.fds.Persistencia.RepOrcamentosJPA;

public class DescontoPadrao implements IDesconto {

    @Override
    public double calcularDesconto(String cliente, double valorCompra) {
        
        //Pedido pedido;
        //if(pedido.getListaProd().size()>5){return 0.05;}
        return 0.0;
    }
    
}
