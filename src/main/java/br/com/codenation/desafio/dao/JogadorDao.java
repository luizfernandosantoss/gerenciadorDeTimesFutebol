package br.com.codenation.desafio.dao;

import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.desafio.model.Jogador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.*;

@ApplicationScope
@Component
public class JogadorDao {

    @Autowired
    private TimeDao timeDao;

    Map<Long,Jogador> listaJogadores = new HashMap<Long, Jogador>();


    public void adicionarJogador(Jogador jogador) {
        timeDao.buscarTimePorId(jogador.getIdTime());
        if(listaJogadores.containsKey(jogador.getId())){
            throw new IdentificadorUtilizadoException("Jogador com id = "+jogador.getId() + " Ja esta cadastrado");
        }
        listaJogadores.put(jogador.getId(),jogador);
        System.out.println(jogador);

    }



    public Jogador buscaJogadorPorId(Long idJogador) {

        Jogador jogador  = listaJogadores.get(idJogador);
        if(jogador == null){
            throw new JogadorNaoEncontradoException("Jogador não encontrado");
        }


        return jogador;
    }


    public Map<Long, Jogador> getListaJogadores() {
        return listaJogadores;
    }

    public List<Jogador> buscarJogadoresDoTime(Long idTime){
        timeDao.buscarTimePorId(idTime);

        List<Jogador> jogadoresList = new ArrayList(getListaJogadores().values());
        List<Jogador> jogadoresTime = new ArrayList<>();
        for(Jogador jogador:jogadoresList){
            if(jogador.getIdTime().equals(idTime)){
                jogadoresTime.add(jogador);
            }
        }

        return jogadoresTime;
    }

    public List<Long> buscarIdJogadoresDoTime(Long idTime){
        List<Long> idJogadores = new ArrayList<>();

        for (Jogador jogador:buscarJogadoresDoTime(idTime)){
            idJogadores.add(jogador.getId());
        }
        return idJogadores;
    }
    public Long buscarJogadorMaisVelho(Long idTime){
        List<Jogador> jogadores = buscarJogadoresDoTime(idTime);
        Collections.sort(jogadores,Comparator.comparing(Jogador::getIdade).reversed());
        return jogadores.get(0).getId();
    }
    public Long buscarMelhorJogadorDoTime(Long idTime){
        List<Jogador> jogadores = buscarJogadoresDoTime(idTime);
        Collections.sort(jogadores,Comparator.comparing(Jogador::getNivelHabilidade).reversed());
        return jogadores.get(0).getId();
    }


}
