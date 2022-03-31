package com.example.folha.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

import com.example.folha.dto.MomentoDTO;
import com.example.folha.dto.RelatorioDTO;
import com.example.folha.entity.Momento;
import com.example.folha.repository.BatidasRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RelatorioService.class)
public class TestRelatorioService {

    @MockBean
    private BatidasRepository batidasRepository;

    @Autowired
    private RelatorioService relatorioService;

    @Test
    void testlistarRelatorio() {

        Mockito.when(batidasRepository.findAll()).thenReturn(listaMomentos());
        Mockito.when(batidasRepository.findByDate(anyString())).thenReturn(listaMomentoDTOs());

        RelatorioDTO relatorioDTO = relatorioService.listarRelatorio("2021-06");

        assertEquals("2021-06", relatorioDTO.getMes());
        assertEquals("PT0S", relatorioDTO.getHorasExcedentesMes());
        assertEquals("PT3H", relatorioDTO.getHorasTrabalhadasMes());
    }

    public List<Momento> listaMomentos() {
        Momento momento = new Momento(), momento1 = new Momento(), momento2 = new Momento(), momento3 = new Momento(), momento4 = new Momento();

        momento.setDataHora("2021-06-22T08:00:00");
        momento1.setDataHora("2021-06-22T09:00:00");
        momento2.setDataHora("2021-06-22T10:00:00");
        momento3.setDataHora("2021-06-22T11:00:00");
        momento4.setDataHora("2021-06-23T12:00:00");

        List<Momento> listaMomentos = new ArrayList<>();
        listaMomentos.add(momento);
        listaMomentos.add(momento1);
        listaMomentos.add(momento2);
        listaMomentos.add(momento3);
        listaMomentos.add(momento4);

        return listaMomentos;
    }


    public List<MomentoDTO> listaMomentoDTOs() {
        MomentoDTO momento = new MomentoDTO(), momento1 = new MomentoDTO(), momento2 = new MomentoDTO(), momento3 = new MomentoDTO();

        momento.setDataHora("2021-06-22T08:00:00");
        momento1.setDataHora("2021-06-22T09:00:00");
        momento2.setDataHora("2021-06-22T10:00:00");
        momento3.setDataHora("2021-06-22T11:00:00");

        List<MomentoDTO> listaMomentoDTOs = new ArrayList<>();
        listaMomentoDTOs.add(momento);
        listaMomentoDTOs.add(momento1);
        listaMomentoDTOs.add(momento2);
        listaMomentoDTOs.add(momento3);

        return listaMomentoDTOs;
    }
}
