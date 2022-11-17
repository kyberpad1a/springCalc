package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

//    @GetMapping("/")
//    public String greeting(Model model) {
//        model.addAttribute("title", "Главная страница");
//        return "home";

//    }
    @GetMapping("/")
    public String getCalc(Model model, @RequestParam(value = "firstDigit", required = false) int firstDigit,
                          @RequestParam(value = "secondDigit", required = false) int secondDigit,
                          @RequestParam(value =  "operationSelection", required = false) String operationSelection){
        model.addAttribute("operationResult", mathResult(firstDigit, secondDigit, operationSelection));
        return "home";
    }
    @PostMapping("/")
    public String postCalc(Model model, @RequestParam(value = "firstDigit", required = false) int firstDigit,
                          @RequestParam(value = "secondDigit", required = false) int secondDigit,
                          @RequestParam(value =  "operationSelection", required = false) String operationSelection){
        model.addAttribute("operationResult", mathResult(firstDigit, secondDigit, operationSelection));
        return "home";
    }

    public double mathResult(int firstDigit, int secondDigit, String operationSelection){
        double operationResult = 0;
        switch (operationSelection) {
            case "+" -> operationResult = firstDigit + secondDigit;
            case "-" -> operationResult = firstDigit - secondDigit;
            case "*" -> operationResult = firstDigit * secondDigit;
            case "/" -> operationResult = firstDigit / secondDigit;
        };
        return operationResult;
    }


}
