package br.fds.Persistencia.Orcamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.fds.Dominio.Entidades.Orcamento;
import br.fds.Dominio.Interfaces.IRepOrcamentos;

@Repository
@Primary
public class RepOrcamentosJPA implements IRepOrcamentos {
    IRepOrcamentosJPA repJPA;

    @Autowired
    public RepOrcamentosJPA(IRepOrcamentosJPA repJPA) {
        this.repJPA = repJPA;
    }

    @Override
    public void save(Orcamento orcamento) {
        repJPA.save(orcamento);
    }

    @Override
    public Orcamento getOrcamento(Long orcamentoId) {
        Orcamento optionalOrcamento = repJPA.findAll().stream().filter(f->f.getId().equals(orcamentoId)).findFirst().orElse(null);
        return optionalOrcamento; 
    }

    @Override
    public List<Orcamento> getHistorico(String cliente) {
        return repJPA.findAll().stream().filter(f->f.getCliente().equals(cliente)).toList();
    }

}
