package com.AppRegistroAcidente.AppRegistroAcidente.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.AppRegistroAcidente.AppRegistroAcidente.models.Cidadao;
import com.AppRegistroAcidente.AppRegistroAcidente.models.Ocorrencia;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.CidadaoRepository;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.OcorrenciaRepository;

@Controller
public class OcorrenciaController {
	
	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;
	
	@Autowired
	private CidadaoRepository cr;
	
	@RequestMapping(value="/ocorrencia", method=RequestMethod.GET)
	public String form() {
		return "appRegistroAcidente/ocorrencia";
	}
	
	@RequestMapping(value="/ocorrencia", method=RequestMethod.POST)
    public String form(Ocorrencia ocorrencia, @RequestParam("cidadaoId") Long cidadaoId) {
        // Buscar o cidadão correspondente ao ID
        Cidadao cidadao = cr.findById(cidadaoId).orElse(null);
        
        if (cidadao != null) {
            // Associar a ocorrência ao cidadão
            ocorrencia.setCidadao(cidadao);
            // Salvar a ocorrência
            ocorrenciaRepository.save(ocorrencia);
            return "redirect:/ocorrencia";
        } else {
            // Lidar com o cenário em que o cidadão não é encontrado
            return "redirect:/ocorrencia?error=cidadaoNotFound";
        }
    }
		
}
