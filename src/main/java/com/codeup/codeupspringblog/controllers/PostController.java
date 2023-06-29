package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public void getPosts() {
        //posts index page
    }

    @GetMapping("/posts{id}")
    @ResponseBody
    public void getSinglePost() {
        //page for individual post
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public void createPostPage() {
        //page to create post
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public void createPost() {
        //creates  a post
    }

}
