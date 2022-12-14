package br.com.samuel.app.usecase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import br.com.samuel.app.config.CloudConfig;

@Service
public class RemoverImagem {

    @Autowired
    private ApplicationContext context;

    public void executar(String nomeImg) throws IOException {
        Cloudinary cloudinary = context.getBean(CloudConfig.class).config();
        Path caminho = Paths.get("imagem/upload/".concat(nomeImg));
        new File(caminho.toString()).delete();
        cloudinary.uploader().destroy(nomeImg, ObjectUtils.emptyMap());
    }
}