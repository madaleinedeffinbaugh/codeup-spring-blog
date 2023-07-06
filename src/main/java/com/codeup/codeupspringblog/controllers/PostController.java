package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/posts")
public class PostController {
    private final PostRepository postDao;
    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping()
    public String getPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/{id}")
    public String getSinglePost(Model model, @PathVariable Long id) {
        model.addAttribute("post", postDao.getReferenceById(id));
        return "posts/show";
    }

    @GetMapping("/create")
    public String createPostPage() {
        return "posts/create";
    }

    @PostMapping("/create")
    public String createPost(@RequestParam(name = "postTitle") String postTitle, @RequestParam(name = "postBody") String postBody, Model model) {
        Post newPost = new Post();
        newPost.setTitle(postTitle);
        newPost.setBody(postBody);
        postDao.save(newPost);
        return "redirect:/posts";
    }

}
