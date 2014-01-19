package com.hospitalapp.web.controller.uam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("login")
public class LoginController {

    @RequestMapping(value = "auth", method = RequestMethod.GET)
    public String auth(){
        return "uam/auth";
    }

    @RequestMapping(value = "denied", method = RequestMethod.GET)
    public String denied(){
        return "uam/auth";
    }
}
