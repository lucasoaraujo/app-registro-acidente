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
import com.AppRegistroAcidente.AppRegistroAcidente.models.Veiculo;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.CidadaoRepository;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.ParteEnvolvidaRepository;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.VeiculoRepository;

@Controller
public class ParteEnvolvidaController {

    @Autowired
    private ParteEnvolvidaRepository parteEnvolvidaRepository;

    @Autowired
    private CidadaoRepository cidadaoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @RequestMapping(value = "/parteenvolvida", method = RequestMethod.GET)
    public String showParteEnvolvidaForm(Model model) {
        model.addAttribute("parteenvolvida", new ParteEnvolvida());
        return "appRegistroAcidente/parteenvolvida";
    }

    @RequestMapping(value = "/parteenvolvida", method = RequestMethod.POST)
    public String saveParteEnvolvida(
        @RequestParam("tipoParticipacao") String tipoParticipacao, 
        @RequestParam("veiculo.placa") String placa,
        @RequestParam("veiculo.modelo") String modelo,
        @RequestParam("veiculo.marca") String marca,
        @RequestParam("veiculo.renavam") String renavam,
        RedirectAttributes redirectAttributes,
        @RequestParam(name = "cidadaoId", required = false) Long cidadaoId
    ) {
        ParteEnvolvida parteEnvolvida = new ParteEnvolvida();
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

        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(placa);
        veiculo.setModelo(modelo);
        veiculo.setMarca(marca);
        veiculo.setRenavam(renavam);

        veiculoRepository.save(veiculo);

        parteEnvolvida.setVeiculo(veiculo);
        parteEnvolvidaRepository.save(parteEnvolvida);
        return "redirect:/parteenvolvida";
    }
}
