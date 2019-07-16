package br.com.nespresso.repositories;

import br.com.nespresso.entities.Categoria;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoriaRepositorioTest {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Test
    public void buscaTodasCategorias(){
        List<Categoria> categorias =
                this.categoriaRepositorio.findAll();

        Assert.assertTrue("Ok!!!", !categorias.isEmpty());
    }

}
