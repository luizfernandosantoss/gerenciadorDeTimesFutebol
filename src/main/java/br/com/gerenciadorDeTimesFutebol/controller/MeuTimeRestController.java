package br.com.gerenciadorDeTimesFutebol.controller;

import br.com.gerenciadorDeTimesFutebol.service.MeuTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeuTimeRestController {

    @Autowired
    private MeuTimeService meuTimeService;

    @GetMapping(value = "/buscarNomeTime")
    public String buscarNomeTime(Long idTime) {

        return meuTimeService.buscarNomeTime(idTime);
    }
}