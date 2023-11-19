package br.fds;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.fds.Dominio.Entidades.Produto;
import br.fds.Dominio.Interfaces.IRepProdutos;
import br.fds.Dominio.Servicos.ServicoEstoque;

public class ServicoEstoqueTest {

    private ServicoEstoque testeServEstoque;
    private IRepProdutos iRepProdutos;
    private List<Produto> listaProdutosDisp;

    @BeforeEach
    public void initialize(){
        //cria os produtos disponiveis P1 disp e P2 não
        Produto p1 = new Produto(1, "P1", 10, 0, 20, 10);
        Produto p2 = new Produto(2, "P2", 20, 10, 20, 5);
        //cria o repositorio falso e faz ele retornar na funcao .all(), todos os produtos 
        iRepProdutos = new IRepProdutos() {

            @Override
            public void save(Produto p) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'save'");
            }

            @Override
            public List<Produto> all() {
                List<Produto> todos = new ArrayList<>();
                todos.add(p1);
                todos.add(p2);
                return todos;
            }

            @Override
            public Produto getProduto(Long chave) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getProduto'");
            }
            
        };
        
        //cria o servicoEstoque com o repositorio
        testeServEstoque = new ServicoEstoque(iRepProdutos);
        //Cria uma lista apenas com os prod disponiveis que é o P1
        listaProdutosDisp = new ArrayList<>();
        listaProdutosDisp.add(p1);
    }
    //testa a funcao prodDisp()
    @Test
    public void testeProdDisp(){
        //Cria uma lista que deve receber a lista filtrada so pelos disponiveis
        List<Produto> resposta = testeServEstoque.prodDisp();
        Assertions.assertEquals(listaProdutosDisp,resposta);
    }
}
