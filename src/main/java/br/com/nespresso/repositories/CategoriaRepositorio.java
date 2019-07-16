package br.com.nespresso.repositories;

import br.com.nespresso.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositorio
        extends JpaRepository<Categoria, Integer> {
}
