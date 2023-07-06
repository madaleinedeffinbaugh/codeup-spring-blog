package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class DiceGameController {

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "dice";
    }

    @GetMapping("/roll-dice/{roll}")
    public String rollDice(@PathVariable int roll, Model model) {
        int countCorrect = 0;
        Random random = new Random();
        List<Integer> randomRolls = new ArrayList<>();
        randomRolls.add(random.nextInt(6) + 1);
        randomRolls.add(random.nextInt(6) + 1);
        randomRolls.add(random.nextInt(6) + 1);
        randomRolls.add(random.nextInt(6) + 1);
        randomRolls.add(random.nextInt(6) + 1);
        randomRolls.add(random.nextInt(6) + 1);
        for (Integer randomRoll : randomRolls) {
            if(roll == randomRoll) {
                countCorrect++;
            }
        }
        model.addAttribute("roll", roll);
        model.addAttribute("rolls", randomRolls);
        model.addAttribute("correct", countCorrect);
        return "dice";
    }
}
