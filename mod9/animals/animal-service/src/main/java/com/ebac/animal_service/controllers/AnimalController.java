package com.ebac.animal_service.controllers;

import com.ebac.animal_service.entidades.Animal;
import com.ebac.animal_service.entidades.DTOs.FuncionariosResgateDTO;
import com.ebac.animal_service.repositorios.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animais")
public class AnimalController {
    AnimalRepository animalRepository;

    @Autowired
    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @PostMapping(value = "cadastrar")
    public ResponseEntity<Animal> cadastrar(@RequestBody Animal animal){
        return ResponseEntity.ok(animalRepository.save(animal));
    }

    @GetMapping(value = "all")
    public ResponseEntity<List<Animal>> getAll(){
        return ResponseEntity.ok(animalRepository.findAll());
    }

    @GetMapping(value = "id/{id}")
    public ResponseEntity<Optional<Animal>> getById(@PathVariable Long id){
        return ResponseEntity.ok(animalRepository.findById(id));
    }

    @GetMapping(value = "nao-adotados")
    public ResponseEntity<Optional<List<Animal>>> getNotAdopted(){
        return ResponseEntity.ok(animalRepository.findNotAdopted());
    }

    @GetMapping(value = "adotados")
    public ResponseEntity<Optional<List<Animal>>> getAdopted(){
        return ResponseEntity.ok(animalRepository.findAdopted());
    }

    @GetMapping(value = "especie/{especie}")
    public ResponseEntity<List<Animal>> getAnimalsByRaca(@PathVariable String especie){
        return ResponseEntity.ok(animalRepository.findByRacaIgnoreCase(especie)
                .orElse(Collections.emptyList()));
    }

    @GetMapping("/resgates-por-funcionario/{periodo}")
    public ResponseEntity<List<FuncionariosResgateDTO>> getResgatesUltimoAno(@PathVariable int periodo) {
        LocalDate dataFim = LocalDate.now();
        LocalDate dataInicio = dataFim.minusYears(periodo);

        List<FuncionariosResgateDTO> resultados = animalRepository.countAnimaisPorFuncionario(dataInicio, dataFim);

        return ResponseEntity.ok(resultados);
    }
}

