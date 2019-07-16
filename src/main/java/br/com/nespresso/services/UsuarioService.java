package br.com.nespresso.services;

import br.com.nespresso.entities.Usuario;
import br.com.nespresso.repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositorio repositorio;

    public Usuario buscaUsuario(String usuario) {
        return this.repositorio.findByLogin(usuario);
    }
}
