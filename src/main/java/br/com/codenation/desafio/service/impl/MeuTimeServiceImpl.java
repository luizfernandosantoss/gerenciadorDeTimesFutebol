package br.com.codenation.desafio.service.impl;

import br.com.codenation.desafio.service.MeuTimeService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class MeuTimeServiceImpl implements MeuTimeService {
    @Override
    public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {

    }

    @Override
    public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        System.out.println("incluirJogador");

    }

    @Override
    public void definirCapitao(Long idJogador) {

    }

    @Override
    public Long buscarCapitaoDoTime(Long idTime) {
        return null;
    }

    @Override
    public String buscarNomeJogador(Long idJogador) {
        return null;
    }

    @Override
    public String buscarNomeTime(Long idTime) {
        return "Vim de outro lugar";
    }

    @Override
    public Long buscarJogadorMaiorSalario(Long idTime) {
        return null;
    }

    @Override
    public BigDecimal buscarSalarioDoJogaodor(Long idJogador) {
        return null;
    }

    @Override
    public List<Long> buscarJogadoresDoTime(Long idTime) {
        return null;
    }

    @Override
    public Long buscarMelhorJogadorDoTime(Long idTime) {
        return null;
    }

    @Override
    public Long buscarJogadorMaisVelho(Long idTime) {
        return null;
    }

    @Override
    public List<Long> buscarTimes() {
        return null;
    }

    @Override
    public List<Long> buscarTopJogadores(Integer top) {
        return null;
    }
}