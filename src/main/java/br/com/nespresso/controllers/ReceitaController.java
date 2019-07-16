package br.com.nespresso.controllers;

import br.com.nespresso.entities.Receita;
import br.com.nespresso.services.ReceitaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;
    
    @GetMapping(value = "/receitas/")
    public ModelAndView buscaReceitas() {
        List<Receita> receitas = this.receitaService.buscaTodas();
        return new ModelAndView("receitas", "listaReceitas", receitas);
    }

    @GetMapping(value = "/receitas/{codigo}")
    public ModelAndView buscaReceita(
            @PathVariable(name = "codigo") int pCodigo) {
        Receita receita = this.receitaService.buscaReceita(pCodigo);
        return new ModelAndView("receita", "receita", receita);
    }
    
  
}















