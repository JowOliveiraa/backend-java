package com.meuprojeto.thymeleafMB.controller;

import com.meuprojeto.thymeleafMB.model.Post;
import com.meuprojeto.thymeleafMB.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostService service;

    @GetMapping
    public List<Post> list () {
        return service.findAll();
    }

    @GetMapping(value = "/posts")
    public ModelAndView getPosts() {
        var mv = new ModelAndView("posts");
        List<Post> posts = service.findAll();
        mv.addObject("posts", posts);
        return mv;

    }

    @GetMapping(value = "/posts/{id}")
    public ModelAndView getById(@PathVariable("id") Long id) {
        var mv  = new ModelAndView("postDetails");
        var post = service.findById(id);
        mv.addObject("post", post);
        return mv;
    }

    @GetMapping(value = "/posts/newpost")
    public String getPostForm() {
        return "postForm";
    }

}
