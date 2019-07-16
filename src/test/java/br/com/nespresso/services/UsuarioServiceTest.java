package br.com.nespresso.services;

import br.com.nespresso.entities.Usuario;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioServiceTest {

    @Autowired
    private UsuarioService usuarioService;

    @Test
    public void usuarioExistenteTest(){

        String usuario = "alice.santos";
        Usuario user = this.usuarioService.buscaUsuario(usuario);

        Assert.assertNotNull(user);

    }
}
