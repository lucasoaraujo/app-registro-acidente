package com.AppRegistroAcidente.AppRegistroAcidente.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.AppRegistroAcidente.AppRegistroAcidente.models.Cidadao;
import com.AppRegistroAcidente.AppRegistroAcidente.models.Ocorrencia;
import com.AppRegistroAcidente.AppRegistroAcidente.models.Veiculo;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.CidadaoRepository;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.OcorrenciaRepository;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.VeiculoRepository;

@Controller
public class OcorrenciaController {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    private CidadaoRepository cidadaoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @RequestMapping(value="/ocorrencia", method=RequestMethod.GET)
    public String form(Model model) {
        model.addAttribute("ocorrencia", new Ocorrencia());
        return "appRegistroAcidente/ocorrencia";
    }
    
    @RequestMapping(value="/ocorrencia", method=RequestMethod.POST)
    public String form(Ocorrencia ocorrencia, Cidadao cidadao, Veiculo veiculo) {
            cidadaoRepository.save(cidadao);
            veiculoRepository.save(veiculo);
            ocorrencia.setCidadao(cidadao);
            ocorrencia.setVeiculo(veiculo);
            ocorrenciaRepository.save(ocorrencia);
        return "redirect:/ocorrencia";
    }
    
    @RequestMapping(value = "/parteenvolvida", method = RequestMethod.GET)
    public String showParteEnvolvidaForm(Model model) {
        model.addAttribute("parteenvolvida", new Ocorrencia());
        return "appRegistroAcidente/parteenvolvida";
    }

    @RequestMapping(value = "/parteenvolvida", method = RequestMethod.POST)
    public String saveParteEnvolvida(Ocorrencia ocorrencia, Cidadao cidadao, Veiculo veiculo) {  
            cidadaoRepository.save(cidadao);
            veiculoRepository.save(veiculo);
            ocorrencia.setCidadao(cidadao);
            ocorrencia.setVeiculo(veiculo);
            ocorrenciaRepository.save(ocorrencia);
  
        return "redirect:/parteenvolvida";
    }
}
