package br.com.hickandrade.teste.repository;

import br.com.hickandrade.teste.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal,Integer> {
}
