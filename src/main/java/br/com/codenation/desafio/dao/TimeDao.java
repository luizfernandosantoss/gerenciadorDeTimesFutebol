package br.com.codenation.desafio.dao;

import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.desafio.model.Jogador;
import br.com.codenation.desafio.model.Time;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.HashMap;
import java.util.Map;

@ApplicationScope
@Component
public class TimeDao {

    private static Map<Long, Time> listaTime = new HashMap<Long, Time>();


    public void adicionarTime(Time time) {
        if (listaTime.containsKey(time.getId())){
            throw new IdentificadorUtilizadoException("Time de id "+time.getId() + " Ja esta cadastrado");
        }else {
            listaTime.put(time.getId(),time);
            System.out.println(listaTime);
        }
    }
    public boolean validarSeTimeExiste(Long idTime){
        if(listaTime.get(idTime) != null){
            return  true;
        }
        return false;
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
}
