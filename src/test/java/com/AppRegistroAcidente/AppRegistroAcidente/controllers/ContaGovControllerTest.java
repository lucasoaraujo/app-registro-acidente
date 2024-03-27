package com.AppRegistroAcidente.AppRegistroAcidente.controllers;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.AppRegistroAcidente.AppRegistroAcidente.models.ContaGov;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.ContaGovRepository;

@WebMvcTest(ContaGovController.class)
public class ContaGovControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContaGovRepository contaGovRepository;
    
    // este teste verifica se o método `processLogin` do controlador funciona corretamente quando um usuário válido é fornecido, 
    // redirecionando-o para a página de seleção (`/selecao`).

    @Test
    public void testProcessLogin_ValidUser_ReturnsRedirectToSelecao() throws Exception {
        // Arrange
        ContaGov mockContaGov = new ContaGov();
        mockContaGov.setUsuario("testUser");
        mockContaGov.setSenha("testPassword");

        when(contaGovRepository.findByUsuarioAndSenha("testUser", "testPassword"))
            .thenReturn(mockContaGov);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .param("usuario", "testUser")
                .param("senha", "testPassword"))
            .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
            .andExpect(MockMvcResultMatchers.redirectedUrl("/selecao"));
    }

}
