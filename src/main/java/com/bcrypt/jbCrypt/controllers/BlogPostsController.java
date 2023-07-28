package com.bcrypt.jbCrypt.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogPostsController {

    @GetMapping("/verified")
    public String showBlogPage(HttpServletRequest request, Model model){

        HttpSession session = request.getSession();

        Object userNameAttribute = session.getAttribute("userName");

        if(userNameAttribute == null){
            return "redirect:/";
        }

        String userName = userNameAttribute.toString();
        model.addAttribute("userName", userName);

        return "loggedIn.html";
    }
}
