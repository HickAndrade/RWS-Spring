package br.com.fiap.teste_h2.repository;

import br.com.fiap.teste_h2.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
}
