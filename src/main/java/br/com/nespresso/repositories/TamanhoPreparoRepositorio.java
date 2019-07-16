package br.com.nespresso.repositories;

import br.com.nespresso.entities.TamanhoPreparo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TamanhoPreparoRepositorio
        extends JpaRepository<TamanhoPreparo, Integer> {
	
	    
}
