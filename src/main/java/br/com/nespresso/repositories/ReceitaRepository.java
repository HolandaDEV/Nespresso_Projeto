package br.com.nespresso.repositories;

import br.com.nespresso.entities.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository
        extends JpaRepository<Receita, Integer> {
}
