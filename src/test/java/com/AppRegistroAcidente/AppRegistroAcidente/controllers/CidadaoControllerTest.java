package com.AppRegistroAcidente.AppRegistroAcidente.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.AppRegistroAcidente.AppRegistroAcidente.models.Cidadao;
import com.AppRegistroAcidente.AppRegistroAcidente.models.ContaGov;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.CidadaoRepository;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.ContaGovRepository;

//7.6. CT006 – Redirecionamento após cadastro
// Este teste verifica se o redirecionamento após o cadastro de um cidadão está funcionando corretamente, simulando uma requisição 
// POST e verificando se a URL redirecionada é a esperada.
@WebMvcTest(CidadaoController.class)
public class CidadaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CidadaoRepository cidadaoRepository;

    @MockBean
    private ContaGovRepository contaGovRepository;

    @Test
    public void testCadastroCidadaoRedirecionamento() throws Exception {
        // Mock do comportamento do repositório
        when(contaGovRepository.save(Mockito.any(ContaGov.class))).thenReturn(new ContaGov());
        when(cidadaoRepository.save(Mockito.any(Cidadao.class))).thenReturn(new Cidadao());

        // Realizar a requisição POST para o endpoint de cadastro
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.post("/cadastroCidadao")
                .param("nome", "João")
                .param("cpf", "12345678900")
                .param("endereco", "Rua A, 123")
                .param("telefone", "999999999")
                .param("email", "joao@example.com")
                .param("usuario", "joao")
                .param("senha", "senha123"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andReturn().getResponse();

        // Verificar se a URL redirecionada é a esperada
        assertEquals("/cadastroCidadao", response.getRedirectedUrl());
    }
}
