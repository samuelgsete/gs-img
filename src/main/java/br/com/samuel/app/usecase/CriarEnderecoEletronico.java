package br.com.samuel.app.usecase;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class CriarEnderecoEletronico {

    public static String executar(String nomeRandomico) {
        return ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("imagem/upload/")
                    .path(nomeRandomico)
                    .toUriString();
    }
}