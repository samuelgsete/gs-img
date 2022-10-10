package br.com.samuel.app.exception.filter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.samuel.app.exception.model.FormatoNaoSuportado;
import br.com.samuel.app.exception.model.RespostaErro;
import br.com.samuel.app.model.ImagemPadrao;

@ControllerAdvice
public class FiltroFormatoNaoSuportado {

    @ExceptionHandler(value = { FormatoNaoSuportado.class })
    public ResponseEntity<RespostaErro> handle(FormatoNaoSuportado ex) {
        RespostaErro erro = new RespostaErro(
                                    HttpStatus.BAD_REQUEST.toString(), 
                                    ex.getMessage(), 
                                    "Formatos aceitos.: ".concat(ImagemPadrao.FORMATOS_ACEITOS)
                                );
        return new ResponseEntity<RespostaErro>(erro, HttpStatus.BAD_REQUEST);
    }
}
