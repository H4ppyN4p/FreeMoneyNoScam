package com.example.freemoneynoscam.controllers;

import com.example.freemoneynoscam.services.DBServiceCode;
import com.example.freemoneynoscam.services.ValidateEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    ValidateEmailService validateEmailService = new ValidateEmailService();
    DBServiceCode dbServiceCode = new DBServiceCode();


    @GetMapping("/")
    public String index(Model m){
        return "index";
    }

    @GetMapping("/sucessEmail")
    public String success(){
        return "success";
    }

    @GetMapping("/FailEmail")
    public String fail(){
        return "fail";
    }

    @PostMapping("/test")
    public String test(WebRequest dataFromForm){

        boolean validEmail = validateEmailService.isEmailValid(dataFromForm.getParameter("email"));

        if (validEmail == true) {
            dbServiceCode.sendEmailToDB(dataFromForm.getParameter("email"));
            return "redirect:/success";
        }

        else {
            return "redirect:/fail";
        }
    }

    @PostMapping("/session")
    public String sessionExample(WebRequest request, HttpSession session){

        return "redirect:/test";
    }
}
