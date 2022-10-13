package br.com.samuel.app.usecase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReceberImagem {
    public ResponseEntity<?> executar(String nomeImg) throws IOException {
        var caminho = Paths.get("imagem/upload/".concat(nomeImg));
        var arquivo = new File(caminho.toString());
        var conexaoArquivo = new FileInputStream(arquivo);
        var img = new ByteArrayResource(conexaoArquivo.readAllBytes());
        conexaoArquivo.close();
        return ResponseEntity
                .ok()
                .contentLength(arquivo.length())
                .contentType(MediaType.IMAGE_PNG)
                .body(img);
    }
}