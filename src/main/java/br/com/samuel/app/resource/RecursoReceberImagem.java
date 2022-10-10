package br.com.samuel.app.resource;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.samuel.app.usecase.ReceberImagem;

@RestController
@RequestMapping("imagem")
public class RecursoReceberImagem {
    
    @Autowired
    private ReceberImagem baixar;

    @GetMapping("/upload/{nomeImg}")
    public ResponseEntity<?> executar(@PathVariable String nomeImg) throws IOException {
        return baixar.executar(nomeImg);
    }
}