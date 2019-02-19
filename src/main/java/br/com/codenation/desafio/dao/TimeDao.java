package br.com.codenation.desafio.dao;

import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
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

}
