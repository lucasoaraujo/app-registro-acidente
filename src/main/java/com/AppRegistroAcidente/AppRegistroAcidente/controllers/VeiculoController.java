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

import com.AppRegistroAcidente.AppRegistroAcidente.models.Veiculo;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    //listarVeiculos: Responde a requisições GET para /veiculos e retorna uma lista de todos os veículos cadastrados.
    @GetMapping
    public ResponseEntity<List<Veiculo>> listarVeiculos() {
        List<Veiculo> veiculos = veiculoRepository.findAll();
        return new ResponseEntity<>(veiculos, HttpStatus.OK);
    }

    //cadastrarVeiculo: Responde a requisições POST para /veiculos e cadastra um novo veículo no banco de dados.
    @PostMapping
    public ResponseEntity<Veiculo> cadastrarVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo novoVeiculo = veiculoRepository.save(veiculo);
        return new ResponseEntity<>(novoVeiculo, HttpStatus.CREATED);
    }

    //buscarVeiculoPorId: Responde a requisições GET para /veiculos/{id} e retorna o veículo correspondente ao ID fornecido.
    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarVeiculoPorId(@PathVariable Long id) {
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
        return new ResponseEntity<>(veiculo, HttpStatus.OK);
    }

    //atualizarVeiculo: Responde a requisições PUT para /veiculos/{id} e atualiza os dados do veículo correspondente ao ID fornecido.
    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        Veiculo veiculoAtualizado = veiculoRepository.findById(id)
                .map(v -> {
                    v.setPlaca(veiculo.getPlaca());
                    v.setModelo(veiculo.getModelo());
                    v.setMarca(veiculo.getMarca());
                    v.setRenavam(veiculo.getRenavam());
                    // Você pode adicionar a lógica de atualização de outros atributos aqui, se necessário
                    return veiculoRepository.save(v);
                })
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
        return new ResponseEntity<>(veiculoAtualizado, HttpStatus.OK);
    }

    //deletarVeiculo: Responde a requisições DELETE para /veiculos/{id} e deleta o veículo correspondente ao ID fornecido.
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarVeiculo(@PathVariable Long id) {
        veiculoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
