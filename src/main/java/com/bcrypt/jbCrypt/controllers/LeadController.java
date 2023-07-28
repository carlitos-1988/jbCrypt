package com.bcrypt.jbCrypt.controllers;

import com.bcrypt.jbCrypt.models.SiteUser;
import com.bcrypt.jbCrypt.repos.UsersRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LeadController {

    @Autowired
    UsersRepository usersRepository;
    @GetMapping("/")
    public String getMainPage(){
        return "welcome.html";
    }

    @GetMapping("/enter")
    public String getLoginPage(){
        return "login.html";
    }

    @GetMapping("/logout")
    public RedirectView logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return new RedirectView("/");
    }


    @PostMapping("/login")
    public RedirectView login(HttpServletRequest request, String userName, String password){

        SiteUser siteUser = usersRepository.findSiteUserByUserName(userName);
        if(siteUser == null){
            return new RedirectView("/");
        }

        if(!BCrypt.checkpw(password,siteUser.getPassword())){
            return new RedirectView("/");
        }

        //Store in session location
        HttpSession session = request.getSession();
        session.setAttribute("userName", userName);

        return new RedirectView("/verified");
    }

    @PostMapping("/signup")
    public RedirectView createSiteUser(String userName, String password){
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(5));

        SiteUser newSiteUser = new SiteUser(userName,hashedPassword);
        System.out.println(userName+ "---------USERNAME-------------");
        usersRepository.save(newSiteUser);

        return new RedirectView("/");
    }


}
