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

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts() {
        var mv = new ModelAndView("posts");
        List<Post> posts = service.findAll();
        mv.addObject("posts", posts);
        return mv;

    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getById(@PathVariable("id") Long id) {
        var mv  = new ModelAndView("postDetails");
        var post = service.findById(id);
        mv.addObject("post", post);
        return mv;
    }

}
