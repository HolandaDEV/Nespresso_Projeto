package br.com.nespresso.services;

import br.com.nespresso.entities.*;
import br.com.nespresso.repositories.CapsulaRepositorio;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReceitaServiceTest {

    @Autowired
    private ReceitaService receitaService;

    @Autowired
    private CapsulaRepositorio capsulaRepositorio;

    @SuppressWarnings("deprecation")
	@Test
    public void cadastrarNovaReceitaTest(){

        Receita receita = new Receita();

        GrauDificuldade dificuldade = new GrauDificuldade();
        dificuldade.setCodigo(1);

        receita.setNome("Xpto");
        receita.setDescricao("Xpto Descricao");
        receita.setGrauDificuldade(dificuldade);
        receita.setRendimento(1);

        Timestamp tempoPreparo = new Timestamp(0);
        tempoPreparo.setMinutes(5);
        receita.setTempoPreparo(tempoPreparo);

        Capsula capsula = capsulaRepositorio.findOne(1);
        ReceitaCapsula rCapsula = new ReceitaCapsula(capsula, receita);
        receita.getCapsulas().add(rCapsula);
        
        
        Keyword keywordOne = new Keyword("xpto", receita);
        receita.getKeywords().add(keywordOne);
        
        Ingrediente ingredienteUm = new Ingrediente("xpto",receita);
        receita.getIngredientes().add(ingredienteUm);

        PassosPreparo primeiroPasso = new PassosPreparo("xpto",receita);
        receita.getPassosPreparo().add(primeiroPasso);
        
        this.receitaService.nova(receita);
    }
    
    
}
