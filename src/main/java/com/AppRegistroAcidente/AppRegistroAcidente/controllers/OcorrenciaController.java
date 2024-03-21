package com.AppRegistroAcidente.AppRegistroAcidente.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.AppRegistroAcidente.AppRegistroAcidente.models.Cidadao;
import com.AppRegistroAcidente.AppRegistroAcidente.models.Ocorrencia;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.CidadaoRepository;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.OcorrenciaRepository;

@Controller
public class OcorrenciaController {
    
    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;
    
    @Autowired
    private CidadaoRepository cidadaoRepository;
    
    
    
    @RequestMapping(value="/ocorrencia", method=RequestMethod.GET)
    public String form(Model model) {
        model.addAttribute("ocorrencia", new Ocorrencia());
        return "appRegistroAcidente/ocorrencia";
    }
    
    @RequestMapping(value="/ocorrencia", method=RequestMethod.POST)
    public String processOcorrencia(
        @RequestParam("dataHora") String dataHora,
        @RequestParam("localizacao") String localizacao,
        @RequestParam("descricao") String descricao,
        @RequestParam("fotos") String fotos,
        @RequestParam("situacao") String situacao,
        RedirectAttributes redirectAttributes,
        @RequestParam(name = "cidadaoId", required = false) Long cidadaoId
    ) {
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setDataHora(dataHora);
        ocorrencia.setLocalizacao(localizacao);
        ocorrencia.setDescricao(descricao);
        ocorrencia.setFotos(fotos);
        ocorrencia.setSituacao(situacao);

        if (cidadaoId != null) {
            Cidadao cidadao = cidadaoRepository.findById(cidadaoId).orElse(null);
            if (cidadao != null) {
                ocorrencia.setCidadao(cidadao);
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Cidadão não encontrado.");
                return "redirect:/ocorrencia";
            }
        }

        ocorrenciaRepository.save(ocorrencia);
        return "redirect:/ocorrencia";
    }
}
