package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.EmailService;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/posts")
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    private EmailService emailService;
    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping()
    public String getPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/{id}")
    public String getSinglePost(Model model, @PathVariable Long id) {
        Optional<Post> optionalPost = postDao.findById(id);
        if(optionalPost.isEmpty()) {
            System.out.println("post with id " + id + " not found.");
            //TODO error page
            return "home";
        }
        model.addAttribute("post", optionalPost.get());
        return "posts/show";
    }

    @GetMapping("/create")
    public String showCreatePostPage() {
        return "posts/create";
    }

    @PostMapping("/create")
//    public String createPost(@RequestParam(name = "postTitle") String postTitle, @RequestParam(name = "postBody") String postBody) {
    public String createPost(@RequestParam String postTitle, @RequestParam String postBody) {
        Optional<User> optionalUser = userDao.findById(1L);
        if(optionalUser.isEmpty()) {
            System.out.println("user with id 1 not found.");
            //TODO error page
            return "home";
        }
        Post newPost = new Post();
        newPost.setTitle(postTitle);
        newPost.setBody(postBody);
        newPost.setUser(optionalUser.get());
        postDao.save(newPost);
        emailService.prepareAndSend(optionalUser.get(),"test","testy");
        return "redirect:/posts";
    }

}
