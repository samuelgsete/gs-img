package br.com.samuel.app.exception.model;

public class FormatoNaoSuportado extends Exception {
    public FormatoNaoSuportado(String mensagem) {
        super(mensagem);
    }
}