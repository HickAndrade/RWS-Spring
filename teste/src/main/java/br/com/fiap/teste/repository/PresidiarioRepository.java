package br.com.fiap.teste.repository;

import br.com.fiap.teste.entity.Presidiario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PresidiarioRepository extends JpaRepository<Presidiario, Integer> {

    List<Presidiario> findByNome(String nome);
}
