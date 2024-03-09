package com.AppRegistroAcidente.AppRegistroAcidente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AppRegistroAcidente.AppRegistroAcidente.models.Ocorrencia;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.OcorrenciaRepository;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;
    
    //O método listarOcorrencias responde a requisições GET para /ocorrencias e retorna uma lista de todas as ocorrências.
    @GetMapping
    public List<Ocorrencia> listarOcorrencias() {
        return ocorrenciaRepository.findAll();
    }
    
    //O método registrarOcorrencia responde a requisições POST para /ocorrencias e registra uma nova ocorrência no banco de dados.
    @PostMapping
    public Ocorrencia registrarOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        // Lógica para registrar a ocorrência no banco de dados
        return ocorrenciaRepository.save(ocorrencia);
    }
    
    //O método buscarOcorrenciaPorId responde a requisições GET para /ocorrencias/{id} e retorna a ocorrência correspondente ao ID fornecido.
    @GetMapping("/{id}")
    public Ocorrencia buscarOcorrenciaPorId(@PathVariable Long id) {
        return ocorrenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ocorrência não encontrada"));
    }

    
}
