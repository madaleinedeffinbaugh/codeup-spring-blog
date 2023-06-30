package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Item;
import io.micrometer.common.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
//@RequestMapping(path = "/hello")
public class HelloController {
    /*
    GET /hello - hello world screen
    GET /hello?name=bob - hello bob
    GET /hello/bob - hello bob
     */

//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello from Spring!";
//    }

//
////    @GetMapping("/hello") -- use if you dont use request mapping at the top
//    @GetMapping()
//    @ResponseBody
//    public String hello(@RequestParam @Nullable String name) {
//        if (name == null) {
//            return getHelloString("world");
//        } else {
//            return getHelloString(name);
//        }
//    }
//
////    @GetMapping("/hello/{name}") -- use if you dont use request mapping at the top
//    @GetMapping("/{name}")
//    @ResponseBody
//    public String helloToName(@PathVariable String name) {
//        return getHelloString(name);
//    }
//
//    private String getHelloString(String name) {
//        return "<h1>Hello " + name + " from Spring!</h1>";
//    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/join")
    public String showJoinForm(Model model) {
        ArrayList<Item> shoppingCart = new ArrayList<>();
        shoppingCart.add(new Item("thing"));
        shoppingCart.add(new Item("thing2"));
        shoppingCart.add(new Item("thing3"));
        model.addAttribute("shoppingCart", shoppingCart);
        model.addAttribute("page_has_error", true);
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }

}
