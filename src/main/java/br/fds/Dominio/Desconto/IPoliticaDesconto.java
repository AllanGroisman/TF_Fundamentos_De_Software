package br.fds.Dominio.Desconto;

import java.util.List;

import br.fds.Dominio.Entidades.Orcamento;

// Interface de desconto
public interface IPoliticaDesconto {
    double getDesconto(List<Orcamento> ultimasCompras);
}

