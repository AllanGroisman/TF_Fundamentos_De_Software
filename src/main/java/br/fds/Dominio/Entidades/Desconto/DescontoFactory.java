package br.fds.Dominio.Entidades.Desconto;

import java.util.ArrayList;
import java.util.List;

import br.fds.Dominio.Entidades.Entidades.Orcamento;

public class DescontoFactory {
    public static IDesconto criarDesconto(String cliente){
        List<IDesconto> descontos = new ArrayList<>();
        descontos.add(new DescontoValorMedio());
        descontos.add(new DescontoComprasRecentes());
        descontos.add(new DescontoPadrao());

        return descontos.stream()
                .max(((d1,d2) -> Double.compare(d1.calcularDesconto(cliente,0.0),d2.calcularDesconto(cliente,0.0))))
                .orElse(new DescontoPadrao());

    }
}
