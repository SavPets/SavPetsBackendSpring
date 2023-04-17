package com.fatec.scc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GUIAnimalCategoryController {

    @GetMapping("/categorias-animais")
    public ModelAndView showCategoryAnimal() {
        return new ModelAndView("/animalCategory/animalCategory");
    }

    @GetMapping("/criar-categoria-animal")
    public ModelAndView showCreateAnimalCategory() {
        return new ModelAndView("/animalCategory/CreateAnimalCategory");
    }

    @GetMapping("/atualizar-categoria-animal")
    public ModelAndView showUpdateAnimalCategory() {
        return new ModelAndView("/animalCategory/UpdateAnimalCategory");
    }
}
