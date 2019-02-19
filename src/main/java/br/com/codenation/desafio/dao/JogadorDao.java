package br.com.codenation.desafio.dao;

import br.com.codenation.desafio.model.Jogador;

import java.util.HashMap;
import java.util.Map;

public class JogadorDao {


    Map<Long,Jogador> listaJogadoresHas = new HashMap<Long, Jogador>();


    public void adicionarJogador(Jogador jogador) {
        listaJogadoresHas.put(jogador.getId(),jogador);

    }







}
