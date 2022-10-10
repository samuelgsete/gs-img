package br.com.samuel.app.exception.filter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.samuel.app.exception.model.ResolucaoNaoSuportada;
import br.com.samuel.app.exception.model.RespostaErro;
import br.com.samuel.app.model.ImagemPadrao;

@ControllerAdvice
public class FiltroResolucaoNaoSuportada {

    @ExceptionHandler(value = { ResolucaoNaoSuportada.class })
    public ResponseEntity<RespostaErro> handle(ResolucaoNaoSuportada ex) {
        RespostaErro erro = new RespostaErro(
                                    HttpStatus.BAD_REQUEST.toString(), 
                                    ex.getMessage(), 
                                    "A imagem não pode ter resolução maior que ".concat(ImagemPadrao.RESOLUCAO_SUPORTADA).concat(" pixels")
                                );
        return new ResponseEntity<RespostaErro>(erro, HttpStatus.BAD_REQUEST);
    }
}