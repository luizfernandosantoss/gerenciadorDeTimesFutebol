package br.com.codenation.desafio.model;

import java.math.BigDecimal;
import java.time.LocalDate;

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
        System.out.println("jogador Criado com sucesso");
    }
}
