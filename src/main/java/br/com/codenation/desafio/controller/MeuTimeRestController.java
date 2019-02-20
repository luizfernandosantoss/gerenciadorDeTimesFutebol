package br.com.codenation.desafio.controller;

import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.desafio.service.MeuTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@RestController
public class MeuTimeRestController {

        @Autowired
        private MeuTimeService meuTimeService;



        @PostMapping(value = "/incluirTime")
        public  ResponseEntity incluirTime(Long id, String nome, String dataCriacao, String corUniformePrincipal, String corUniformeSecundario){
            LocalDate dataCri = null;
            try {
                dataCri = LocalDate.parse(dataCriacao);
            }catch (Exception e){
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            meuTimeService.incluirTime(id,nome,dataCri,corUniformePrincipal,corUniformeSecundario);
            return new ResponseEntity(HttpStatus.CREATED);
        }
        @PostMapping(value = "/definirCapitao")
        public ResponseEntity definirCapitao (Long idJogador){
                meuTimeService.definirCapitao(idJogador);
                return new ResponseEntity(HttpStatus.CREATED);
        }

        @GetMapping(value = "/buscarCapitaoDoTime")
        public ResponseEntity<Long> buscarCapitaoDoTime (Long idTime) {
            try {
                return new ResponseEntity<>(meuTimeService.buscarCapitaoDoTime(idTime),HttpStatus.OK);
            }catch (TimeNaoEncontradoException | CapitaoNaoInformadoException e){
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, e.getMessage(), e);
            }
        }
        
        @GetMapping(value = "/buscarNomeTime")
        public String buscarNomeTime(Long idTime) {
            try{
                return meuTimeService.buscarNomeTime(idTime);
            }catch (TimeNaoEncontradoException  e){
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, e.getMessage(), e);
            }
        }

}

