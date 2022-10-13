package br.com.samuel.app.usecase;

import java.io.File;
import java.nio.file.Paths;
import org.springframework.stereotype.Service;

@Service
public class RemoverImagem {
    public void executar(String nomeImg) {
        var caminho = Paths.get("imagem/upload/".concat(nomeImg));
        new File(caminho.toString()).delete();
    }
}