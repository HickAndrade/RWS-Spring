package br.com.fiap.exercicio05.repository;

import br.com.fiap.exercicio05.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository
        extends JpaRepository<Produto,Integer> {

   List<Produto> findByNome(String nome);
    List<Produto> findByCodigo(int codigo);
    List<Produto> findByNomeAndNovo(String nome, boolean novo);
    List<Produto> findByPrecoGreaterThan(Double preco);
    List<Produto> findByNovoOrderByNome(boolean novo);
    List<Produto> findByNomeIgnoreCaseOrderByPrecoAsc(String nome);



}
