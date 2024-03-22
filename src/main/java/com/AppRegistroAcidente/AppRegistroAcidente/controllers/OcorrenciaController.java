package com.AppRegistroAcidente.AppRegistroAcidente.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String processOcorrencia(
            @Valid @ModelAttribute("ocorrencia") Ocorrencia ocorrencia,
            BindingResult result,
            @RequestParam("placa") String placa,
            @RequestParam("modelo") String modelo,
            @RequestParam("marca") String marca,
            @RequestParam("renavam") String renavam,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            return "appRegistroAcidente/ocorrencia";
        }

        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(placa);
        veiculo.setModelo(modelo);
        veiculo.setMarca(marca);
        veiculo.setRenavam(renavam);

        veiculoRepository.save(veiculo);

        Cidadao cidadao = ocorrencia.getCidadao();
        if (cidadao != null) {
            cidadao = cidadaoRepository.findById(cidadao.getId()).orElse(null);
            if (cidadao == null) {
                redirectAttributes.addFlashAttribute("errorMessage", "Cidadão não encontrado.");
                return "redirect:/ocorrencia";
            }
            ocorrencia.setCidadao(cidadao);
        }

        ocorrenciaRepository.save(ocorrencia);
        return "redirect:/ocorrencia";
    }

}
