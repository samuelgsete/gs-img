package br.com.samuel.app.usecase;

class Jpeg {
    public static final String TIPO = "imagem/jpeg";
    public static final String FORMATO = ".jpg";
}

class Png {
    public static final String TIPO = "imagem/png";
    public static final String FORMATO = ".png";
}

public class DefinirFormato {
    public static String executar(String tipoImagem) {
        if(tipoImagem.toLowerCase().equals(Jpeg.TIPO.toLowerCase())) {
            return Jpeg.FORMATO;
        }
        else {
            return Png.FORMATO;
        }
    }
}