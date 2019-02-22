package br.com.codenation.desafio.dao;

import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
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
}
