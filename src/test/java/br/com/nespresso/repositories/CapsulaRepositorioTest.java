package br.com.nespresso.repositories;

import br.com.nespresso.entities.Capsula;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CapsulaRepositorioTest {

    @Autowired
    private CapsulaRepositorio capsulaRepositorio;

    @Test
    public void buscaTodasCapsulas(){
        List<Capsula> capsulas =
                this.capsulaRepositorio.findAll();

        Assert.assertTrue(!capsulas.isEmpty());
    }
}
