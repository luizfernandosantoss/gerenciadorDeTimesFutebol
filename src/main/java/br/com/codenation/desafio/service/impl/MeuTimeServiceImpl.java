package br.com.codenation.desafio.service.impl;

import br.com.codenation.desafio.dao.JogadorDao;
import br.com.codenation.desafio.dao.TimeDao;
import br.com.codenation.desafio.model.Jogador;
import br.com.codenation.desafio.model.Time;
import br.com.codenation.desafio.service.MeuTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class MeuTimeServiceImpl implements MeuTimeService {


    @Autowired
    private TimeDao timeDao;

    @Autowired
    private JogadorDao jogadorDao;

    @Override
    public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        Time time = new Time(id,nome,dataCriacao,corUniformePrincipal,corUniformeSecundario);
        timeDao.adicionarTime(time);
    }

    @Override
    public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        Jogador jogador = new Jogador(id,idTime,nome,dataNascimento,nivelHabilidade,salario);
        jogadorDao.adicionarJogador(jogador);
    }

    @Override
    public void definirCapitao(Long idJogador) {
        Jogador jogadorlocal = jogadorDao.buscaJogadorPorId(idJogador);
        timeDao.definirCapitao(jogadorlocal.getId(),jogadorlocal.getIdTime());
    }

    @Override
    public Long buscarCapitaoDoTime(Long idTime) {
        return timeDao.buscarCapitaoDoTime(idTime);

    }

    @Override
    public String buscarNomeJogador(Long idJogador) {
        Jogador jogador= jogadorDao.buscaJogadorPorId(idJogador);
        return jogador.getNome();
    }

    @Override
    public String buscarNomeTime(Long idTime) {
        return timeDao.buscaNomeTime(idTime);
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
        return jogadorDao.buscarIdJogadoresDoTime(idTime);
    }

    @Override
    public Long buscarMelhorJogadorDoTime(Long idTime) {
        return null;
    }

    @Override
    public Long buscarJogadorMaisVelho(Long idTime) {
        return jogadorDao.buscarJogadorMaisVelho(idTime);
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
