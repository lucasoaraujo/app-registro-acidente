package com.AppRegistroAcidente.AppRegistroAcidente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AppRegistroAcidente.AppRegistroAcidente.models.ParteEnvolvida;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.ParteEnvolvidaRepository;

@RestController
@RequestMapping("/partesenvolvidas")
public class ParteEnvolvidaController {

    @Autowired
    private ParteEnvolvidaRepository parteEnvolvidaRepository;
    
    //listarPartesEnvolvidas: Responde a requisições GET para /partesenvolvidas e retorna uma lista de todas as partes envolvidas cadastradas.
    @GetMapping
    public ResponseEntity<List<ParteEnvolvida>> listarPartesEnvolvidas() {
        List<ParteEnvolvida> partesEnvolvidas = parteEnvolvidaRepository.findAll();
        return new ResponseEntity<>(partesEnvolvidas, HttpStatus.OK);
    }

    //cadastrarParteEnvolvida: Responde a requisições POST para /partesenvolvidas e cadastra uma nova parte envolvida no banco de dados.
    @PostMapping
    public ResponseEntity<ParteEnvolvida> cadastrarParteEnvolvida(@RequestBody ParteEnvolvida parteEnvolvida) {
        ParteEnvolvida novaParteEnvolvida = parteEnvolvidaRepository.save(parteEnvolvida);
        return new ResponseEntity<>(novaParteEnvolvida, HttpStatus.CREATED);
    }
    
    //buscarParteEnvolvidaPorId: Responde a requisições GET para /partesenvolvidas/{id} e retorna a parte envolvida correspondente ao ID fornecido.
    @GetMapping("/{id}")
    public ResponseEntity<ParteEnvolvida> buscarParteEnvolvidaPorId(@PathVariable Long id) {
        ParteEnvolvida parteEnvolvida = parteEnvolvidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ParteEnvolvida não encontrada"));
        return new ResponseEntity<>(parteEnvolvida, HttpStatus.OK);
    }

    //atualizarParteEnvolvida: Responde a requisições PUT para /partesenvolvidas/{id} e atualiza os dados da parte envolvida correspondente ao ID fornecido.
    @PutMapping("/{id}")
    public ResponseEntity<ParteEnvolvida> atualizarParteEnvolvida(@PathVariable Long id, @RequestBody ParteEnvolvida parteEnvolvida) {
        ParteEnvolvida parteEnvolvidaAtualizada = parteEnvolvidaRepository.findById(id)
                .map(p -> {
                    p.setNome(parteEnvolvida.getNome());
                    p.setCpf(parteEnvolvida.getCpf());
                    p.setVeiculo(parteEnvolvida.getVeiculo());
                    p.setTipoParticipacao(parteEnvolvida.getTipoParticipacao());
                    p.setOcorrencia(parteEnvolvida.getOcorrencia());
                    // Você pode adicionar a lógica de atualização de outros atributos aqui, se necessário
                    return parteEnvolvidaRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("ParteEnvolvida não encontrada"));
        return new ResponseEntity<>(parteEnvolvidaAtualizada, HttpStatus.OK);
    }

    //deletarParteEnvolvida: Responde a requisições DELETE para /partesenvolvidas/{id} e deleta a parte envolvida correspondente ao ID fornecido.
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarParteEnvolvida(@PathVariable Long id) {
        parteEnvolvidaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
