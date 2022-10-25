package br.com.samuel.app.usecase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReceberImagem {
    public ResponseEntity<?> executar(String nomeImg) throws IOException {
        Path caminho = Paths.get("imagem/upload/".concat(nomeImg));
        File arquivo = new File(caminho.toString());
        FileInputStream conexaoArquivo = new FileInputStream(arquivo);
        ByteArrayResource img = new ByteArrayResource(conexaoArquivo.readAllBytes());
        conexaoArquivo.close();
        return ResponseEntity
                .ok()
                .contentLength(arquivo.length())
                .contentType(MediaType.IMAGE_PNG)
                .body(img);
    }
}