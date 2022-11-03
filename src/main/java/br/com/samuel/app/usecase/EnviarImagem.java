package br.com.samuel.app.usecase;

import java.io.IOException;
import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.samuel.app.exception.model.FormatoNaoSuportado;
import br.com.samuel.app.exception.model.ResolucaoNaoSuportada;
import br.com.samuel.app.model.Imagem;

@Service
public class EnviarImagem {

    @Autowired
    private SalvarNaNuvem nuvem;

    public Imagem executar(MultipartFile arquivo) throws IOException, ResolucaoNaoSuportada, FormatoNaoSuportado {
        String formato = DefinirFormato.executar(arquivo.getContentType());
        Integer largura = ImageIO.read(arquivo.getInputStream()).getWidth();
        Integer altura = ImageIO.read(arquivo.getInputStream()).getHeight();
        ValidarImagem.executar(largura, altura, formato);
        String nomeOriginal = arquivo.getOriginalFilename();
        String nomeRandomico = CriarNomeRandomico.executar();
        SalvarImagem.executar(arquivo, nomeRandomico);
        String url = nuvem.salvar(nomeRandomico); // gera a url da claoudinary
        Long tamanho = arquivo.getSize();
        Imagem novaImagem = new Imagem(nomeOriginal, nomeRandomico, url, tamanho, formato, largura, altura);
        return novaImagem;
    }
}