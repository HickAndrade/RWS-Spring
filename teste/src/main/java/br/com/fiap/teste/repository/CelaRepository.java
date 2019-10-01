package br.com.fiap.teste.repository;

import br.com.fiap.teste.entity.Cela;
import br.com.fiap.teste.entity.Presidiario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CelaRepository extends JpaRepository<Cela, Integer> {
   List<Cela> findByNome(String nome);
    List<Cela> findByPresidiario(List<Presidiario> presidiarios);
}
