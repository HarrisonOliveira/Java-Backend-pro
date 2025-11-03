package com.ebac.animal_service.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nomeProvisorio;

    @Column(nullable = false)
    private String especie;

    @Column(nullable = false)
    private String raca;

    @Column(nullable = false)
    private String porte;

    @Column(nullable = false)
    private Integer idadeEstimada;

    @Column(nullable = false)
    private String nomeRecebedor;

    @Column(nullable = false)
    private LocalDate dataEntrada;

    @Column
    private LocalDate dataAdocao;

    @Column
    private LocalDate dataObito;

    @Column
    private String observacoes;

    public Long getId() {
        return id;
    }

    public String getNomeProvisorio() {
        return nomeProvisorio;
    }

    public void setNomeProvisorio(String nomeProvisorio) {
        this.nomeProvisorio = nomeProvisorio;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public Integer getIdadeEstimada() {
        return idadeEstimada;
    }

    public void setIdadeEstimada(Integer idadeEstimada) {
        this.idadeEstimada = idadeEstimada;
    }

    public String getNomeRecebedor() {
        return nomeRecebedor;
    }

    public void setNomeRecebedor(String nomeRecebedor) {
        this.nomeRecebedor = nomeRecebedor;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataAdocao() {
        return dataAdocao;
    }

    public void setDataAdocao(LocalDate dataAdocao) {
        this.dataAdocao = dataAdocao;
    }

    public LocalDate getDataObito() {
        return dataObito;
    }

    public void setDataObito(LocalDate dataObito) {
        this.dataObito = dataObito;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}