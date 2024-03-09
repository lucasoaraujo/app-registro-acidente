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

import com.AppRegistroAcidente.AppRegistroAcidente.models.ContaGov;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.ContaGovRepository;

@RestController
@RequestMapping("/contagov")
public class ContaGovController {

    @Autowired
    private ContaGovRepository contaGovRepository;
    
    //listarContasGov: Responde a requisições GET para /contagov e retorna uma lista de todas as contas do governo cadastradas.
    @GetMapping
    public ResponseEntity<List<ContaGov>> listarContasGov() {
        List<ContaGov> contasGov = contaGovRepository.findAll();
        return new ResponseEntity<>(contasGov, HttpStatus.OK);
    }

    //cadastrarContaGov: Responde a requisições POST para /contagov e cadastra uma nova conta do governo no banco de dados.
    @PostMapping
    public ResponseEntity<ContaGov> cadastrarContaGov(@RequestBody ContaGov contaGov) {
        ContaGov novaContaGov = contaGovRepository.save(contaGov);
        return new ResponseEntity<>(novaContaGov, HttpStatus.CREATED);
    }

    //buscarContaGovPorId: Responde a requisições GET para /contagov/{id} e retorna a conta do governo correspondente ao ID fornecido.
    @GetMapping("/{id}")
    public ResponseEntity<ContaGov> buscarContaGovPorId(@PathVariable Long id) {
        ContaGov contaGov = contaGovRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ContaGov não encontrada"));
        return new ResponseEntity<>(contaGov, HttpStatus.OK);
    }

    //atualizarContaGov: Responde a requisições PUT para /contagov/{id} e atualiza os dados da conta do governo correspondente ao ID fornecido.
    @PutMapping("/{id}")
    public ResponseEntity<ContaGov> atualizarContaGov(@PathVariable Long id, @RequestBody ContaGov contaGov) {
        ContaGov contaGovAtualizada = contaGovRepository.findById(id)
                .map(c -> {
                    c.setUsuario(contaGov.getUsuario());
                    c.setSenha(contaGov.getSenha());
                    // Você pode adicionar a lógica de atualização de outros atributos aqui, se necessário
                    return contaGovRepository.save(c);
                })
                .orElseThrow(() -> new RuntimeException("ContaGov não encontrada"));
        return new ResponseEntity<>(contaGovAtualizada, HttpStatus.OK);
    }

    //deletarContaGov: Responde a requisições DELETE para /contagov/{id} e deleta a conta do governo correspondente ao ID fornecido.
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarContaGov(@PathVariable Long id) {
        contaGovRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
