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

    @Autowired
    private ParteEnvolvidaRepository parteEnvolvidaRepository;

    @Autowired
    private CidadaoRepository cidadaoRepository;

    @RequestMapping(value = "/parteenvolvida", method = RequestMethod.GET)
    public String showParteEnvolvidaForm(Model model) {
        model.addAttribute("parteenvolvida", new ParteEnvolvida());
        return "appRegistroAcidente/parteenvolvida";
    }

    @RequestMapping(value = "/parteenvolvida", method = RequestMethod.POST)
    public String saveParteEnvolvida(
        @RequestParam("nome") String nome,
        @RequestParam("cpf") String cpf,
        @RequestParam("tipoParticipacao") String tipoParticipacao, // Corrigido para "tipoParticipacao"
        RedirectAttributes redirectAttributes,
        @RequestParam(name = "cidadaoId", required = false) Long cidadaoId
    ) {
    		ParteEnvolvida parteEnvolvida = new ParteEnvolvida();
    		parteEnvolvida.setNome(nome);
    		parteEnvolvida.setCpf(cpf);
    		parteEnvolvida.setTipoParticipacao(tipoParticipacao);
    		
    		 if (cidadaoId != null) {
    	            Cidadao cidadao = cidadaoRepository.findById(cidadaoId).orElse(null);
    	            if (cidadao != null) {
    	                parteEnvolvida.setCidadao(cidadao);
    	            } else {
    	                redirectAttributes.addFlashAttribute("errorMessage", "Cidadão não encontrado.");
    	                return "redirect:/parteenvolvida";
    	            }
    	        }

    	        parteEnvolvidaRepository.save(parteEnvolvida);
    	        return "redirect:/parteenvolvida";
    	    }
    	}
    		
       