package br.com.samuel.app.usecase;

import java.io.IOException;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import br.com.samuel.app.config.CloudConfig;

@Service
public class SalvarNaNuvem {

    @Autowired
    private ApplicationContext context;

    public String salvar(String nomeRandomico) throws IOException {
        String caminho = Paths.get("imagem/upload/".concat(nomeRandomico)).toString();
        Cloudinary cloudinary = context.getBean(CloudConfig.class).config();
        cloudinary.uploader().upload(caminho, ObjectUtils.asMap("public_id", nomeRandomico));
        return cloudinary.url().generate(nomeRandomico);
    }
}