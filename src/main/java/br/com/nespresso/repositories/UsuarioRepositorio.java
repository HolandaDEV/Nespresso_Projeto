package br.com.nespresso.repositories;

import br.com.nespresso.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio
        extends JpaRepository<Usuario, Integer> {

    /**
     * busca um usuario por login
     *
     * @param login login do usuario
     * @return @{@link Usuario}
     */
    Usuario findByLogin(String login);
}
