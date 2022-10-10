package br.com.samuel.app.exception.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RespostaErro {
    private String codigo;
    private String mensagem;
    private String detalhes;
}