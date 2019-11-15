package com.jyyr.ssm.controller;

import com.jyyr.ssm.entity.ResponseResult;
import com.jyyr.ssm.entity.User;
import com.jyyr.ssm.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private UserServiceImpl userService;

    @ResponseBody
    @RequestMapping(value = "regInfo.do",method = RequestMethod.POST)
    public ResponseResult<Void> regInfo(User user){
        Map<String,String> map = new HashMap<>();
//        System.out.println("++++++++++++++  "+user);
        userService.registUser(user);
//        System.out.println("++++++++++++++   " + map);
        return new ResponseResult<Void>();
    }

    @ResponseBody
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    public ResponseResult<Void> login(@RequestParam("phone")String phone, @RequestParam("password") String password, HttpSession session){
        System.out.println(">>>>>>>>>>>>>>>>>  phone = "+phone +" ,password = "+ password);
        User user = userService.login(phone, password);
        session.setAttribute("username", user.getUsername());
        session.setAttribute("phone", phone);
        session.setAttribute("uid", user.getId());
        return new ResponseResult<Void>();
    }

    @ResponseBody
    @RequestMapping(value = "logManager.do",method = RequestMethod.POST)
    public ResponseResult<Void> logManager(@RequestParam("phone")String phone, @RequestParam("password") String password, HttpSession session){
        System.out.println(">>>>>>>>>>>>>>>>  phone = "+phone +" ,password = "+ password);
        User user = userService.logManager(phone, password);
        session.setAttribute("username", user.getUsername());
        session.setAttribute("phone", phone);
        session.setAttribute("uid", user.getId());
        return new ResponseResult<Void>();
    }


}
