package com.ebac.animal_service.repositorios;

import com.ebac.animal_service.entidades.Animal;

import com.ebac.animal_service.entidades.DTOs.FuncionariosResgateDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.*;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NULL ORDER BY a.dataEntrada")
    public Optional<List<Animal>> findNotAdopted();

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NOT NULL")
    public Optional<List<Animal>> findAdopted();

    @Query("SELECT a FROM Animal a WHERE a.especie = :especie")
    public Optional<List<Animal>> findByRacaIgnoreCase(String especie);

    @Query("SELECT new com.ebac.animal_service.entidades.DTOs.FuncionariosResgateDTO(a.nomeRecebedor, COUNT(a)) " +
            "FROM Animal a " +
            "WHERE a.dataEntrada BETWEEN :dataInicial AND :dataFinal " +
            "GROUP BY a.nomeRecebedor " +
            "ORDER BY a.nomeRecebedor")
    public List<FuncionariosResgateDTO> countAnimaisPorFuncionario (
            @Param("dataInicial") LocalDate dataInicial,
            @Param("dataFinal") LocalDate dataFinal);

}
