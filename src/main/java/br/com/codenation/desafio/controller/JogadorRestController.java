package br.com.codenation.desafio.controller;

import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.desafio.service.MeuTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(value = "/buscarNomeJogador")
    public ResponseEntity<String> buscarNomeJogador(Long idJogador){
        try {
            return  new ResponseEntity<>(meuTimeService.buscarNomeJogador(idJogador),HttpStatus.OK);
        }catch (TimeNaoEncontradoException e){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
    @GetMapping(value = "buscarJogadoresDoTime")
    public ResponseEntity<List<Long>> buscarJogadoresDoTime(Long idTime){
        try {
            return  new ResponseEntity<>(meuTimeService.buscarJogadoresDoTime(idTime),HttpStatus.OK);
        }catch (TimeNaoEncontradoException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }



}
