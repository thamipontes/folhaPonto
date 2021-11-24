package com.example.folha.service;

import com.example.folha.dto.AlocacaoDTO;
import com.example.folha.dto.MomentoDTO;
import com.example.folha.exception.ApiRequestExcept;
import com.example.folha.repository.AlocacoesRepository;
import com.example.folha.repository.BatidasRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;

@ContextConfiguration(classes = AlocacoesService.class)
@ExtendWith(SpringExtension.class)
class TesteAlocacaoService {

    @Autowired
    private AlocacoesService alocacoesService;

    @MockBean
    private BatidasRepository batidasRepository;

    @MockBean
    private AlocacoesRepository alocacoesRepository;

    @Test
    void testvalidaQuantidadeHoraAlocada() {
        AlocacaoDTO alocacaoDTO = new AlocacaoDTO();
        alocacaoDTO.setDia("2018-08-22");
        alocacaoDTO.setNomeProjeto("ACME Corporation");
        alocacaoDTO.setTempo("PT20H30M0S");

        Mockito.when(batidasRepository.findByDate(anyString())).thenReturn(listaMomentoDTOs());

        Exception exception = assertThrows(ApiRequestExcept.class, () -> {
            alocacoesService.validaQuantidadeHoraAlocada(alocacaoDTO);
        });

        String expectedMessage = "Não pode alocar tempo maior que o tempo trabalhado no dia";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    public List<MomentoDTO> listaMomentoDTOs() {
        MomentoDTO momento = new MomentoDTO(), momento1 = new MomentoDTO(), momento2 = new MomentoDTO(),
                momento3 = new MomentoDTO();

        momento.setDataHora("2018-08-22T08:00:00");
        momento1.setDataHora("2018-08-22T09:00:00");
        momento2.setDataHora("2018-08-22T10:00:00");
        momento3.setDataHora("2018-08-22T11:00:00");


        List<MomentoDTO> listaMomentoDTOs = new ArrayList<>();
        listaMomentoDTOs.add(momento);
        listaMomentoDTOs.add(momento1);
        listaMomentoDTOs.add(momento2);
        listaMomentoDTOs.add(momento3);


        return listaMomentoDTOs;

    }


}
