package br.fds.Dominio.Entidades.Desconto;

public interface IDesconto {
    double calcularDesconto(String cliente, double valorCompra);
}
