package com.meuprojeto.thymeleafMB.controller;

import com.meuprojeto.thymeleafMB.model.Post;
import com.meuprojeto.thymeleafMB.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostService service;



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

    @GetMapping(value = "/newpost")
    public String getPostForm() {
        return "postForm";
    }

    @PostMapping(value = "/newpost")
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se todos os campos foram preenchidos!");
            return "redirect:/newpost";
        }
        var newPost = new Post(post);
        service.save(newPost);
        return "redirect:/posts";
    }


}
