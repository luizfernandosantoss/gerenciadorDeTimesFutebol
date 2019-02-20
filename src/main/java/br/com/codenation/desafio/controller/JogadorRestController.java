package br.com.codenation.desafio.controller;

import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.desafio.service.MeuTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
            return new ResponseEntity(HttpStatus.CREATED);
        }

        meuTimeService.incluirJogador(id, idTime, nome, dataNasc, nivelHabilidade,salario);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/buscarNomeJogador")
    public ResponseEntity<String> buscarNomeJogador(Long idJogador){
        try {
            return  new ResponseEntity<>(meuTimeService.buscarNomeJogador(idJogador),HttpStatus.OK);
        }catch (TimeNaoEncontradoException e){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }



}
