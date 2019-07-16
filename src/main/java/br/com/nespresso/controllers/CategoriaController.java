package br.com.nespresso.controllers;

import br.com.nespresso.entities.Categoria;
import br.com.nespresso.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/categorias/")
    public ModelAndView getCategorias(){
        List<Categoria> categorias =
                this.categoriaService.buscaTodasCategorias();
        return new ModelAndView("categorias",
                "categorias",
                categorias);
    }
}
