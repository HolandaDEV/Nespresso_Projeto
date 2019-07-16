package br.com.nespresso.controllers;

import br.com.nespresso.entities.Capsula;
import br.com.nespresso.services.CapsulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CapsulaController {

    @Autowired
    private CapsulaService capsulaService;

    @GetMapping(value = "/capsulas/")
    public ModelAndView buscaCapsulas() {
        List<Capsula> capsulas = this.capsulaService.buscaTodas();
        return new ModelAndView("capsulas", "listinha", capsulas);
    }

    @GetMapping(value = "/capsulas/categoria/{codigo}")
    public ModelAndView buscaCapsulas(
            @PathVariable(name = "codigo") int pCodigo) {
        List<Capsula> capsulas = this.capsulaService.buscaPorCategoria(pCodigo);
        return new ModelAndView("capsulas", "listinha", capsulas);
    }

    @GetMapping(value = "/capsulas/{codigo}")
    public ModelAndView buscaCapsula(
            @PathVariable(name = "codigo") int pCodigo) {
        Capsula capsula = this.capsulaService.buscaCapsula(pCodigo);
        return new ModelAndView("capsula", "capsula", capsula);
    }

    @GetMapping(value = "/capsulas/nova")
    public ModelAndView novaCapsula() {
        Capsula capsula = new Capsula();
        return new ModelAndView("nova-capsula", "nova", capsula);
    }

    @PostMapping(value = "/capsulas/nova")
    public ModelAndView novaCapsula(Capsula novaCapsula) {
        Capsula capsula = this.capsulaService.nova(novaCapsula);

        if (capsula.getCodigo() != null)
            return this.buscaCapsulas();

        return null;
    }

    @GetMapping(value = "/capsulas/{codigo}/remover")
    public ModelAndView removerCapsula(
            @PathVariable(value = "codigo") int pCodigo) {
        this.capsulaService.remover(pCodigo);
        return this.buscaCapsulas();
    }

    @GetMapping(value = "/capsulas/{codigo}/atualizar")
    public ModelAndView atualizarCapsula(
            @PathVariable(value = "codigo") int pCodigo) {
        Capsula capsula = this.capsulaService.buscaCapsula(pCodigo);

        if (capsula != null)
            return new ModelAndView("atualiza-capsula", "capsula", capsula);

        return this.buscaCapsulas();
    }

    @PostMapping(value = "/capsulas/atualiza")
    public ModelAndView atualizarCapsula(Capsula capsula){
        capsula = this.capsulaService.atualizarCapsula(capsula);
        return this.buscaCapsulas();
    }
}
















