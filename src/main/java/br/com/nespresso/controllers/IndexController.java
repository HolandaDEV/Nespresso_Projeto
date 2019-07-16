package br.com.nespresso.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping(value = "/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
