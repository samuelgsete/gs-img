package br.com.samuel.app.usecase;

import br.com.samuel.app.exception.model.FormatoNaoSuportado;
import br.com.samuel.app.exception.model.ResolucaoNaoSuportada;
import br.com.samuel.app.model.ImagemPadrao;

public class ValidarImagem {
    public static void executar(Integer largura,Integer altura,String formato) throws ResolucaoNaoSuportada, FormatoNaoSuportado {
        if(largura > ImagemPadrao.LARGURA_MAXIMA || altura > ImagemPadrao.ALTURA_MAXIMA) {
            throw new ResolucaoNaoSuportada("Resolucao não suportada");
        }
        else if(!ImagemPadrao.FORMATOS_ACEITOS.contains(formato)) {
            throw new FormatoNaoSuportado("Formato não suportado");
        }
    }
}
