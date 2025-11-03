package com.ebac.animal_service.entidades.DTOs;

public class FuncionariosResgateDTO {
    private String nomeFuncionario;
    private Long quantidadeResgates;

    public FuncionariosResgateDTO(String nomeFuncionario, Long quantidadeResgates) {
        this.nomeFuncionario = nomeFuncionario;
        this.quantidadeResgates = quantidadeResgates;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public Long getQuantidadeResgates() {
        return quantidadeResgates;
    }

    public void setQuantidadeResgates(Long quantidadeResgates) {
        this.quantidadeResgates = quantidadeResgates;
    }
}
