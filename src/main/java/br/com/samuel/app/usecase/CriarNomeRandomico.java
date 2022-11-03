package br.com.samuel.app.usecase;

import java.util.UUID;

public class CriarNomeRandomico {
    public static String executar() {
        return UUID.randomUUID().toString();
    }
}