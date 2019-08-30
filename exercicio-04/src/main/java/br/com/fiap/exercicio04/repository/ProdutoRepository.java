package br.com.fiap.exercicio04.repository;

import br.com.fiap.exercicio04.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    List<Produto> findByNome(String nome);
}
