package com.meuprojeto.thymeleafMB.postconstruct;

import com.meuprojeto.thymeleafMB.model.Post;
import com.meuprojeto.thymeleafMB.repository.PostRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component public class Save {

    @Autowired
    PostRepository repository;

    //@PostConstruct //Essa anotação construct faz com que toda vez que a aplicação seja iniciada, ela execute esse metodo
    public void salvar () {
        var post1 = new Post();
        post1.setAuthor("Michele Brito");
        post1.setTitle("Springboot");
        post1.setText("Aprendendo Spring de uma forma descomplicada!");

        var post2 = new Post();
        post2.setAuthor("Michele Brito");
        post2.setTitle("Docker");
        post2.setText("Aprendendo Docker de uma forma descomplicada!");

        var save1 = new Post(post1);
        var save2 = new Post(post2);

        repository.save(save1);
        repository.save(save2);

    }
}
