package com.AppRegistroAcidente.AppRegistroAcidente.controllers;

// Importações necessárias para realizar os testes unitários e simular comportamentos
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// Importações específicas para utilização do JUnit e do Mockito
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

// Importações relacionadas aos pacotes do projeto
import com.AppRegistroAcidente.AppRegistroAcidente.models.Cidadao;
import com.AppRegistroAcidente.AppRegistroAcidente.models.Ocorrencia;
import com.AppRegistroAcidente.AppRegistroAcidente.models.Veiculo;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.CidadaoRepository;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.OcorrenciaRepository;
import com.AppRegistroAcidente.AppRegistroAcidente.repository.VeiculoRepository;

// Anotação para estender funcionalidades do Mockito no JUnit
@ExtendWith(MockitoExtension.class)
public class OcorrenciaControllerTest {
	
	// 7.3. CT003- Registro de ocorrência
	/* verifica se o método form do controlador OcorrenciaController funciona corretamente ao registrar uma ocorrência. 
	 * Ele valida a entrada de dados, simula o comportamento dos repositórios ao salvar as informações e verifica se o 
	 * redirecionamento e o salvamento da ocorrência ocorrem conforme o esperado.
	 */

    // Mocks para simular o comportamento de repositórios e do Model
    @Mock
    private OcorrenciaRepository ocorrenciaRepository;

    @Mock
    private CidadaoRepository cidadaoRepository;

    @Mock
    private VeiculoRepository veiculoRepository;

    // Injeção dos mocks no controlador a ser testado
    @InjectMocks
    private OcorrenciaController controller;

    @Mock
    private Model model;

    // Método executado antes de cada teste para configurar o Mock do Model
    @BeforeEach
    public void setup() {
        model = mock(Model.class);
    }

    // Teste para verificar se o método form do controlador retorna a página correta ao receber um pedido GET
    @Test
    public void testFormGetMethod() {
        assertEquals("appRegistroAcidente/ocorrencia", controller.form(model));
    }

    // Teste para verificar se o método form do controlador processa corretamente um pedido POST
    @Test
    public void testFormPostMethod() {
        // Criação de objetos necessários para o teste
        Ocorrencia ocorrencia = new Ocorrencia();
        Cidadao cidadao = new Cidadao();
        Veiculo veiculo = new Veiculo();

        // Configuração do comportamento dos mocks para o método save dos repositórios
        when(cidadaoRepository.save(cidadao)).thenReturn(cidadao);
        when(veiculoRepository.save(veiculo)).thenReturn(veiculo);

        // Verificação se o redirecionamento após o método form é correto e se o save do repositório ocorre
        assertEquals("redirect:/ocorrencia", controller.form(ocorrencia, cidadao, veiculo));
        verify(ocorrenciaRepository, times(1)).save(ocorrencia);
    }

    // Teste para verificar se o método showParteEnvolvidaForm retorna a página correta ao receber um pedido GET
    @Test
    public void testShowParteEnvolvidaFormGetMethod() {
        assertEquals("appRegistroAcidente/parteenvolvida", controller.showParteEnvolvidaForm(model));
    }

    // Teste para verificar se o método saveParteEnvolvida processa corretamente um pedido POST
    @Test
    public void testSaveParteEnvolvidaPostMethod() {
        // Criação de objetos necessários para o teste
        Ocorrencia ocorrencia = new Ocorrencia();
        Cidadao cidadao = new Cidadao();
        Veiculo veiculo = new Veiculo();

        // Configuração do comportamento dos mocks para o método save dos repositórios
        when(cidadaoRepository.save(cidadao)).thenReturn(cidadao);
        when(veiculoRepository.save(veiculo)).thenReturn(veiculo);

        // Verificação se o redirecionamento após o método saveParteEnvolvida é correto e se o save do repositório ocorre
        assertEquals("redirect:/parteenvolvida", controller.saveParteEnvolvida(ocorrencia, cidadao, veiculo));
        verify(ocorrenciaRepository, times(1)).save(ocorrencia);
    }
}
