package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/posts")
public class PostController {

    @GetMapping()
    @ResponseBody
    public String getPosts() {
        return "posts index page";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String getSinglePost(@PathVariable Long id) {
        return "page for individual post" + id;
    }

    @GetMapping("/create")
    @ResponseBody
    public String createPostPage() {
        return "page to create post";
    }

    @PostMapping("/create")
    @ResponseBody
    public String createPost() {
        return "creates  a post";
    }

}
