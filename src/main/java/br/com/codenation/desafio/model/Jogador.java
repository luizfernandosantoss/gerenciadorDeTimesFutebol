package br.com.codenation.desafio.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;


public class Jogador {


    private Long id;
    private Long idTime;
    private String nome;
    private Integer idade;
    private LocalDate dataNascimento;
    private BigDecimal salario;
    private Integer nivelHabilidade;


    public Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        this.id = id;
        this.idTime = idTime;
        this.nome = nome;
        this.dataNascimento =  dataNascimento;
        this.nivelHabilidade = nivelHabilidade;
        this.salario = salario;
        Period period = Period.between(dataNascimento,LocalDate.now());
        this.idade =  period.getYears();
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", idTime=" + idTime +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", dataNascimento=" + dataNascimento +
                ", salario=" + salario +
                ", nivelHabilidade=" + nivelHabilidade +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Long getIdTime() {
        return idTime;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }
}
