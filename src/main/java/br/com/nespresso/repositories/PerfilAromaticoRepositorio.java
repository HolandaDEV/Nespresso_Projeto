package br.com.nespresso.repositories;

import br.com.nespresso.entities.PerfilAromatico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilAromaticoRepositorio
        extends JpaRepository<PerfilAromatico, Integer> {
	
	    
}
