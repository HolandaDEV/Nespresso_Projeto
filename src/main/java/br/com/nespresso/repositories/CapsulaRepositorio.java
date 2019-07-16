package br.com.nespresso.repositories;

import br.com.nespresso.entities.Capsula;
import br.com.nespresso.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CapsulaRepositorio
        extends JpaRepository<Capsula, Integer> {

    List<Capsula> findByCategoria(Categoria categoria);
}
