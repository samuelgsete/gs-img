package br.com.samuel.app.resource;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.samuel.app.usecase.RemoverImagem;

@RestController
@RequestMapping("imagem")
public class RecursoRemoverImagem {

    @Autowired
    private RemoverImagem remover;

    @DeleteMapping("upload/{nomeImg}")
    public ResponseEntity<?> executar(@PathVariable String nomeImg) throws IOException {
        remover.executar(nomeImg);
        return ResponseEntity.ok().build();
    }
}