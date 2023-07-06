package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/posts")
public class PostController {

    @GetMapping()
    public String getPosts(Model model) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("My post", "cats r so cool"));
        posts.add(new Post("My second post", "dogs drool"));
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/{id}")
    public String getSinglePost(Model model, @PathVariable Long id) {
        model.addAttribute("post", new Post("My post", "cats r so cool"));
        return "posts/show";
    }

    @GetMapping("/create")
    @ResponseBody
    public String createPostPage() {
        return "page to create post";
    }

    @PostMapping("/create")
    @ResponseBody
    public String createPost() {
        return "creates a post";
    }

}
