package br.com.samuel.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Imagem {
    private String nomeOriginal;
    private String nomeRandomico;
    private String url;
    private Long tamanho;
    private String formato;
    private Integer largura;
    private Integer altura;
}