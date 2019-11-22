package com.jyyr.ssm.controller;

import com.jyyr.ssm.entity.Managers;
import com.jyyr.ssm.entity.ResponseResult;
import com.jyyr.ssm.service.ManagersService;
import com.jyyr.ssm.service.impl.ManagersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/managers")
public class ManagersController {

    @Autowired
    private ManagersService managersService;


    @ResponseBody
    @RequestMapping(value = "logManager.do",method = RequestMethod.POST)
    public ResponseResult<Void> logManager(@RequestParam("managerphone")String managerphone, @RequestParam("managerpassword") String managerpassword, HttpSession session){
        System.out.println(">>>>>>>>>>>>>>>>  phone = "+managerphone +" ,password = "+ managerpassword);
        Managers managers = managersService.logManager(managerphone, managerpassword);
        session.setAttribute("manager",managers);
        return new ResponseResult<Void>();
    }

    @RequestMapping(value = "crawlerTest.do")
    public String crawlerTest(){
        return "crowlerTest";
    }
}


