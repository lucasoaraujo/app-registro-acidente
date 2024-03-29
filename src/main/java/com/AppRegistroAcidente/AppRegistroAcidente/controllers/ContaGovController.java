package com.AppRegistroAcidente.AppRegistroAcidente.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.AppRegistroAcidente.AppRegistroAcidente.models.ContaGov;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.ContaGovRepository;

@Controller
public class ContaGovController {
    
    @Autowired
    private ContaGovRepository contaGovRepository;

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String showLoginPage(Model model) {
        model.addAttribute("usuario", new ContaGov());
        return "appRegistroAcidente/login";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String processLogin(@RequestParam("usuario") String usuario, 
                               @RequestParam("senha") String senha,
                               RedirectAttributes redirectAttributes) {
            // Verificar se o usuário existe no banco de dados
            ContaGov contaGov = contaGovRepository.findByUsuarioAndSenha(usuario, senha);
            if (contaGov != null) {
                // Usuário e senha válidos, redirecionar para a página de seleção
                return "redirect:/selecao";
            } else {
                // Usuário ou senha inválidos, redirecionar de volta para a página de login com uma mensagem de erro
                redirectAttributes.addFlashAttribute("errorMessage", "Usuário ou senha inválidos.");
                return "redirect:/login";
            }
        }

}
