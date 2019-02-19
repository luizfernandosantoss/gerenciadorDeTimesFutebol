package br.com.codenation.desafio.controller;

import br.com.codenation.desafio.service.MeuTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
@RestController
public class JogadorRestController {

    @Autowired
    private MeuTimeService meuTimeService;

    @PostMapping(value = "/incluirJogador")
    public ResponseEntity incluirJogador (Long id, Long idTime, String nome, String dataNascimento, Integer nivelHabilidade, BigDecimal salario){

        LocalDate dataNasc = null;
        try {
            dataNasc = LocalDate.parse(dataNascimento);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        meuTimeService.incluirJogador(id, idTime, nome, dataNasc, nivelHabilidade,salario);
        return new ResponseEntity(HttpStatus.OK);
    }



}
