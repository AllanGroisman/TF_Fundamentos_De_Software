package br.fds.Dominio;

import java.util.List;

import br.fds.Dominio.Entidades.Estoque;

public interface IRepEstoque {
    List<Estoque> all();
    Estoque getEstoque(String nome);
    
} 
