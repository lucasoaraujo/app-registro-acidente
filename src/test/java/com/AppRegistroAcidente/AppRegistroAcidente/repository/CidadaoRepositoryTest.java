package com.AppRegistroAcidente.AppRegistroAcidente.repository;


// está verificando se a funcionalidade de salvar um Cidadao e uma ContaGov no banco de dados está funcionando corretamente.
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import com.AppRegistroAcidente.AppRegistroAcidente.models.Cidadao;
import com.AppRegistroAcidente.AppRegistroAcidente.models.ContaGov;


@DataJpaTest
@Transactional
public class CidadaoRepositoryTest {

    @Autowired
    private CidadaoRepository cr;

    @Autowired
    private ContaGovRepository contaGovRepository;
    
    @Test
    @Order(1)
    public void testSaveCidadaoAndContaGov() {
        // Criação de uma nova conta do governo
        ContaGov contaGov = new ContaGov();
        // Setar atributos da contaGov

        // Salvar a contaGov no repositório
        contaGovRepository.save(contaGov);

        // Criação de um novo cidadão
        Cidadao cidadao = new Cidadao();
        // Setar atributos do cidadão

        // Vincular o cidadão à contaGov
        cidadao.setContaGov(contaGov);

        // Salvar o cidadão no repositório
        cr.save(cidadao);

        // Consultar o cidadão no banco de dados pelo ID
        Cidadao cidadaoSalvo = cr.findById(cidadao.getId()).orElse(null);

        // Verificar se o cidadão foi salvo corretamente
        assertNotNull(cidadaoSalvo);
        assertEquals(cidadao.getNome(), cidadaoSalvo.getNome());
        assertEquals(cidadao.getCpf(), cidadaoSalvo.getCpf());
        assertEquals(cidadao.getEndereco(), cidadaoSalvo.getEndereco());
        assertEquals(cidadao.getTelefone(), cidadaoSalvo.getTelefone());
        assertEquals(cidadao.getEmail(), cidadaoSalvo.getEmail());
        assertNotNull(cidadaoSalvo.getContaGov());
        assertEquals(contaGov.getId(), cidadaoSalvo.getContaGov().getId());
        // Adicione mais verificações conforme necessário
    }

}
