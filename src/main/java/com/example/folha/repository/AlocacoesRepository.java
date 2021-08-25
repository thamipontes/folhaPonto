package com.example.folha.repository;

import com.example.folha.dto.AlocacaoDTO;
import com.example.folha.entity.Alocacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlocacoesRepository extends JpaRepository<Alocacao, Long> {

    @Query("SELECT new com.example.folha.dto.AlocacaoDTO(a.dia, a.nomeProjeto, a.tempo) from Alocacao a " +
            "where a.dia like :dataAlocacao")
    List<AlocacaoDTO> findByDate(@Param("dataAlocacao") String dataAlocacao);

}
