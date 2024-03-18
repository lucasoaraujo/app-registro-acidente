package com.AppRegistroAcidente.AppRegistroAcidente.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.AppRegistroAcidente.AppRegistroAcidente.models.Cidadao;
import com.AppRegistroAcidente.AppRegistroAcidente.models.ContaGov;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.CidadaoRepository;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.ContaGovRepository;

@Controller
public class CidadaoController {
	
	@Autowired
	private CidadaoRepository cr;
	
	@Autowired
	private ContaGovRepository contaGovRepository;
	
	@RequestMapping(value="/cadastroCidadao", method=RequestMethod.GET)
	public String form() {
		return "appRegistroAcidente/cadastroCidadao";
	}

	@RequestMapping(value="/cadastroCidadao", method=RequestMethod.POST)
	public String form(Cidadao cidadao, ContaGov contaGov) {
		
		contaGovRepository.save(contaGov);
	    cidadao.setContaGov(contaGov);
	    cr.save(cidadao);
		return "redirect:/cadastroCidadao";
	}
    

}
