package com.codeup.codeupspringblog.controllers;

import io.micrometer.common.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/hello")
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


//    @GetMapping("/hello") -- use if you dont use request mapping at the top
    @GetMapping()
    @ResponseBody
    public String hello(@RequestParam @Nullable String name) {
        if (name == null) {
            return getHelloString("world");
        } else {
            return getHelloString(name);
        }
    }

//    @GetMapping("/hello/{name}") -- use if you dont use request mapping at the top
    @GetMapping("/{name}")
    @ResponseBody
    public String helloToName(@PathVariable String name) {
        return getHelloString(name);
    }

    private String getHelloString(String name) {
        return "<h1>Hello " + name + " from Spring!</h1>";
    }
}
