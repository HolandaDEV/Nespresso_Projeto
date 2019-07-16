package br.com.nespresso.services;

import br.com.nespresso.entities.Capsula;
import br.com.nespresso.entities.CapsulaCaracteristica;
import br.com.nespresso.entities.CapsulaPerfilAromatico;
import br.com.nespresso.entities.CapsulaTamanhoPreparo;
import br.com.nespresso.entities.Caracteristica;
import br.com.nespresso.entities.Categoria;
import br.com.nespresso.entities.PerfilAromatico;
import br.com.nespresso.entities.TamanhoPreparo;
import br.com.nespresso.repositories.CaracteristicaRepositorio;
import br.com.nespresso.repositories.PerfilAromaticoRepositorio;
import br.com.nespresso.repositories.TamanhoPreparoRepositorio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CapsulaServiceTest {

    @Autowired
    private CapsulaService capsulaService;
    
    @Autowired
    private CaracteristicaRepositorio caracteristicaRepositorio;
    
    @Autowired
    private PerfilAromaticoRepositorio perfilAroRepositorio;

    @Autowired
    private TamanhoPreparoRepositorio tamPreparoRepositorio;
    @Test
    public void buscaCapsulasPorCategoria(){
        List<Capsula> capsulas =
                this.capsulaService.buscaPorCategoria(4);

        Assert.assertTrue(!capsulas.isEmpty());
    }

    @Test
    public void novaCapsula(){

        Categoria categoria = new Categoria();
        categoria.setCodigo(5);

        Capsula capsula = new Capsula();
        capsula.setCategoria(categoria);
        capsula.setNome("xpto");
        capsula.setHabilitado(true);
        capsula.setQuantidadeUnitaria((short) 1);
        capsula.setPreco(2.5);
        
        
        Caracteristica car = caracteristicaRepositorio.findOne(2);
        CapsulaCaracteristica cCaracteristica = new CapsulaCaracteristica(capsula,car,(short)2);
        capsula.getCaracteristica().add(cCaracteristica);
        
        PerfilAromatico pAro = perfilAroRepositorio.findOne(5);
        CapsulaPerfilAromatico cpAro = new CapsulaPerfilAromatico(capsula,pAro);
        capsula.getPerfilAromatico().add(cpAro);
        
        TamanhoPreparo tp = tamPreparoRepositorio.findOne(2);
        CapsulaTamanhoPreparo ctp = new CapsulaTamanhoPreparo(capsula,tp);
        capsula.getTamanhoPreparo().add(ctp);

        capsula = this.capsulaService.nova(capsula);

        //Assert.assertNotNull(capsula.getCodigo());
    }
    
    
}
