package br.com.samuel.app.usecase;

import br.com.samuel.app.exception.model.FormatoNaoSuportado;

class Jpeg {
    public static final String TIPO = "image/jpeg";
    public static final String FORMATO = ".jpg";
}

class Png {
    public static final String TIPO = "image/png";
    public static final String FORMATO = ".png";
}

public class DefinirFormato {
    public static String executar(String tipoImagem) throws FormatoNaoSuportado {
        if(tipoImagem.toLowerCase().equals(Jpeg.TIPO.toLowerCase()))
            return Jpeg.FORMATO;
        else if(tipoImagem.toLowerCase().equals(Png.TIPO.toLowerCase()))
            return Png.FORMATO;
        else 
            throw new FormatoNaoSuportado("Arquivo não suportado");
    }
}