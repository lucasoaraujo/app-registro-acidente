package com.AppRegistroAcidente.AppRegistroAcidente.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SelecaoController {

    @GetMapping("/selecao")
    public String showSelectionPage() {
        return "selecao";
    }
}
