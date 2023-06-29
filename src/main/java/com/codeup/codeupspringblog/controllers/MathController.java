package com.codeup.codeupspringblog.controllers;

import io.micrometer.common.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/3/and/4")
    @ResponseBody
    public int add() {
        return 7;
    }

    @GetMapping("/subtract/3/from/10")
    @ResponseBody
    public int subtract() {
        return 7;
    }

    @GetMapping("/multiply/4/and/5")
    @ResponseBody
    public int multiply() {
        return 20;
    }

    @GetMapping("/divide/6/by/3")
    @ResponseBody
    public int divide() {
        return 2;
    }
}
