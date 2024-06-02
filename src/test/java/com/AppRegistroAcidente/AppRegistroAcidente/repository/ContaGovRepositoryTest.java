package com.AppRegistroAcidente.AppRegistroAcidente.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.AppRegistroAcidente.AppRegistroAcidente.models.ContaGov;

@DataJpaTest
public class ContaGovRepositoryTest {
	
	// 7.13. CT013 - Verificação de Autenticação Inválida

    @Autowired
    private ContaGovRepository contaGovRepository;

    @Test
    public void testFindByUsuarioAndSenha() {
        // Cria uma instância de ContaGov e a salva no banco de dados
        ContaGov contaGov = new ContaGov();
        contaGov.setUsuario("testUser");
        contaGov.setSenha("testPassword");
        contaGovRepository.save(contaGov);

        // Procura a ContaGov pelo nome de usuário e senha
        ContaGov foundContaGov = contaGovRepository.findByUsuarioAndSenha("testUser", "testPassword");
        
        // Verifica se a ContaGov encontrada não é nula
        assertNotNull(foundContaGov);
    }

    // Adicione mais testes conforme necessário para outros métodos ou cenários
}
