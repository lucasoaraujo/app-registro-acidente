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

import com.AppRegistroAcidente.AppRegistroAcidente.models.Cidadao;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.CidadaoRepository;

@RestController
@RequestMapping("/cidadao")
public class CidadaoController {

    @Autowired
    private CidadaoRepository cidadaoRepository;

    //listarCidadaos: Responde a requisições GET para /cidadao e retorna uma lista de todos os cidadãos cadastrados.
    @GetMapping
    public ResponseEntity<List<Cidadao>> listarCidadaos() {
        List<Cidadao> cidadaos = cidadaoRepository.findAll();
        return new ResponseEntity<>(cidadaos, HttpStatus.OK);
    }

    //cadastrarCidadao: Responde a requisições POST para /cidadao e cadastra um novo cidadão no banco de dados.
    @PostMapping
    public ResponseEntity<Cidadao> cadastrarCidadao(@RequestBody Cidadao cidadao) {
        Cidadao novoCidadao = cidadaoRepository.save(cidadao);
        return new ResponseEntity<>(novoCidadao, HttpStatus.CREATED);
    }
    
    //buscarCidadaoPorId: Responde a requisições GET para /cidadao/{id} e retorna o cidadão correspondente ao ID fornecido.
    @GetMapping("/{id}")
    public ResponseEntity<Cidadao> buscarCidadaoPorId(@PathVariable Long id) {
        Cidadao cidadao = cidadaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cidadão não encontrado"));
        return new ResponseEntity<>(cidadao, HttpStatus.OK);
    }

    //atualizarCidadao: Responde a requisições PUT para /cidadao/{id} e atualiza os dados do cidadão correspondente ao ID fornecido.
    @PutMapping("/{id}")
    public ResponseEntity<Cidadao> atualizarCidadao(@PathVariable Long id, @RequestBody Cidadao cidadao) {
        Cidadao cidadaoAtualizado = cidadaoRepository.findById(id)
                .map(c -> {
                    c.setNome(cidadao.getNome());
                    c.setCpf(cidadao.getCpf());
                    c.setEndereco(cidadao.getEndereco());
                    c.setTelefone(cidadao.getTelefone());
                    c.setEmail(cidadao.getEmail());
                    // Você pode adicionar a lógica de atualização de outros atributos aqui, se necessário
                    return cidadaoRepository.save(c);
                })
                .orElseThrow(() -> new RuntimeException("Cidadão não encontrado"));
        return new ResponseEntity<>(cidadaoAtualizado, HttpStatus.OK);
    }

    //deletarCidadao: Responde a requisições DELETE para /cidadao/{id} e deleta o cidadão correspondente ao ID fornecido.
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCidadao(@PathVariable Long id) {
        cidadaoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
