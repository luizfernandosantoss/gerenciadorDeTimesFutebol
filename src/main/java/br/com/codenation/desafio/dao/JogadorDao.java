package br.com.codenation.desafio.dao;

import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.desafio.model.Jogador;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.HashMap;
import java.util.Map;

@ApplicationScope
@Component
public class JogadorDao {


    Map<Long,Jogador> listaJogadores = new HashMap<Long, Jogador>();


    public void adicionarJogador(Jogador jogador) {
        listaJogadores.put(jogador.getId(),jogador);

    }


    public Jogador buscaJogadorPorId(Long idJogador) {

        Jogador jogador = null;
        try{
            jogador  = listaJogadores.get(idJogador);
        }catch (NullPointerException e){
            throw new JogadorNaoEncontradoException("Jogador não encontrado");
        }

        return jogador;
    }
}
