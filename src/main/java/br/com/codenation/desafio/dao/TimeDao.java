package br.com.codenation.desafio.dao;

import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.desafio.model.Jogador;
import br.com.codenation.desafio.model.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.math.BigDecimal;
import java.util.*;

@ApplicationScope
@Component
public class TimeDao {
    @Autowired
    private JogadorDao jogadorDao;

    private static Map<Long, Time> listaTime = new HashMap<Long, Time>();


    public void adicionarTime(Time time) {
        if (listaTime.containsKey(time.getId())){
            throw new IdentificadorUtilizadoException("Time de id "+time.getId() + " Ja esta cadastrado");
        }else {
            listaTime.put(time.getId(),time);
            System.out.println(listaTime);
        }
    }

    public String buscaNomeTime(Long idTime) {
        String  nomeTime = null;
        try{
            nomeTime = listaTime.get(idTime).getNome();
        }catch (NullPointerException e){
            throw new TimeNaoEncontradoException("Time não encontrado");
        }

        return nomeTime;
    }
    public Time buscarTimePorId(Long idTime){
        Time time = null;
        time  = listaTime.get(idTime);
        if(time == null){
            throw new TimeNaoEncontradoException("Time não encontrado");
        }
        return time;
    }

    public void definirCapitao(Long idJogador,Long idTime) {
        Time time = buscarTimePorId(idTime);
        time.setCapitao(idJogador);
    }

    public Long buscarCapitaoDoTime(Long idTime) {
        if (buscarTimePorId(idTime).getCapitao() == null){
            throw new CapitaoNaoInformadoException("Time não tem capitão");
        }
        return buscarTimePorId(idTime).getCapitao();
    }

    public Map<Long,Jogador> buscarJogadoresPorIdTime(Long idTime) {
        Map<Long,Jogador> jogadores = jogadorDao.getListaJogadores();
        Map<Long,Jogador> jogadoresTime=null;
        System.out.println(jogadores.values());
        System.out.println(jogadores.size());
        System.out.println(jogadores.keySet());


        return jogadoresTime;
    }

    public Long buscarJogadorMaiorSalario(Long idTime) {
        List<Jogador> jogadores = (List<Jogador>) buscarJogadoresPorIdTime(idTime);
        HashMap<Long,BigDecimal> salarios = null;
        for (Jogador jogador:jogadores){
            salarios.put(jogador.getId(),jogador.getSalario());
        }
        salarios.values();
        return 1L;
    }
}
