package com.jyyr.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {

    @RequestMapping("main.do")
    public String main(){
        return "main";
    }


    @RequestMapping("regNow.do")
    public String regNow(){
        return "reg";
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("managerIndex.do")
    public String manager_index(){
        return "managerIndex";
    }
}
