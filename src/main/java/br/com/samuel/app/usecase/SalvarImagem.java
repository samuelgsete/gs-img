package br.com.samuel.app.usecase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.web.multipart.MultipartFile;

public class SalvarImagem {
    public static void executar(MultipartFile arquivo, String nomeRandomico) throws IOException {
        var caminho = Paths.get("imagem/upload/".concat(nomeRandomico));
        Files.copy(arquivo.getInputStream(), caminho, StandardCopyOption.REPLACE_EXISTING);
    }
}