package com.meuprojeto.thymeleafMB.service;

import com.meuprojeto.thymeleafMB.model.Post;
import com.meuprojeto.thymeleafMB.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository repository;

    public List<Post> findAll() {
        return repository.findAll();
    }

    public Post findById (Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public Post save (Post post) {
        var newPost = new Post(post);
        repository.save(newPost);

        return newPost;
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
