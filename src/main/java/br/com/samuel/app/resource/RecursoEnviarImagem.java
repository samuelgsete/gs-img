package br.com.samuel.app.resource;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.samuel.app.model.Imagem;
import br.com.samuel.app.usecase.EnviarImagem;

@RestController
@RequestMapping("imagem")
public class RecursoEnviarImagem {

    @Autowired
    private EnviarImagem upload;
    
    @PostMapping("/upload")
    public ResponseEntity<Imagem> executar(@RequestParam MultipartFile img) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(upload.executar(img));
    }
}