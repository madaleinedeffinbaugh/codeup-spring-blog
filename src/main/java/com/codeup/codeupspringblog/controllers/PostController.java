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
    public String showCreatePostPage(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute Post post) {
        Optional<User> optionalUser = userDao.findById(1L);
        if(optionalUser.isEmpty()) {
            System.out.println("user with id 1 not found.");
            //TODO error page
            return "home";
        }
        post.setUser(optionalUser.get());
        postDao.save(post);
        emailService.prepareAndSend(optionalUser.get(),"test","testy");
        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String showEditPostPage(@PathVariable Long id, Model model) {
        Optional<Post> post = postDao.findById(id);
        if(post.isEmpty()) {
            System.out.println("post not found.");
            //TODO error page
            return "home";
        }
        model.addAttribute("post", post.get());
        return "posts/create";
    }

    @PostMapping("/{id}/edit")
    public String editPost(@PathVariable Long id, @ModelAttribute Post post) {
        Optional<User> optionalUser = userDao.findById(1L);
        if(optionalUser.isEmpty()) {
            System.out.println("user with id 1 not found.");
            //TODO error page
            return "home";
        }
//        post.setId(id);
        post.setUser(optionalUser.get());
        postDao.save(post);
        emailService.prepareAndSend(optionalUser.get(),"test","testy");
        return "redirect:/posts";
    }

}
