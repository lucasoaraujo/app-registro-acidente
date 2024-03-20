package com.AppRegistroAcidente.AppRegistroAcidente.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.AppRegistroAcidente.AppRegistroAcidente.models.Cidadao;
import com.AppRegistroAcidente.AppRegistroAcidente.models.ParteEnvolvida;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.CidadaoRepository;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.ParteEnvolvidaRepository;

@Controller
public class ParteEnvolvidaController {

    /*@Autowired
    private ParteEnvolvidaRepository parteEnvolvidaRepository;

    @Autowired
    private CidadaoRepository cidadaoRepository;

    @RequestMapping(value = "/parteenvolvida", method = RequestMethod.GET)
    public String showParteEnvolvidaForm(Model model) {
        model.addAttribute("parteEnvolvida", new ParteEnvolvida());
        return "appRegistroAcidente/parteenvolvida";
    }

    @RequestMapping(value = "/parteenvolvida", method = RequestMethod.POST)
    public String saveParteEnvolvida(@RequestParam("cidadaoId") Long cidadaoId, ParteEnvolvida parteEnvolvida,
            RedirectAttributes redirectAttributes) {
        // Buscar o cidadão correspondente ao ID
        Cidadao cidadao = cidadaoRepository.findById(cidadaoId).orElse(null);

        if (cidadao != null) {
            // Associar a parte envolvida ao cidadão
            parteEnvolvida.setCidadao(cidadao);
            // Salvar a parte envolvida
            parteEnvolvidaRepository.save(parteEnvolvida);
            redirectAttributes.addFlashAttribute("successMessage", "Parte envolvida salva com sucesso!");
        } else {
            // Lidar com o cenário em que o cidadão não é encontrado
            redirectAttributes.addFlashAttribute("errorMessage", "Cidadão não encontrado.");
        }

        return "redirect:/selecao"; // Redirecionar de volta para a página de seleção
    }*/
}
