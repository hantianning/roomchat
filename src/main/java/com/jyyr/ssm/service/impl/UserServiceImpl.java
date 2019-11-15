package com.jyyr.ssm.service.impl;

import com.jyyr.ssm.dao.ManagersDAO;
import com.jyyr.ssm.dao.UserDAO;
import com.jyyr.ssm.entity.User;
import com.jyyr.ssm.service.UserService;
import com.jyyr.ssm.service.ex.*;
import com.jyyr.ssm.tools.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ManagersDAO managersDAO;


    @Override
    public void registUser(User user) throws PhoneConflictException, InsertDataException {
        List<User> userB = userDAO.selectByPhone(user.getPhone());
        if(userB.size() > 0){
            throw new PhoneConflictException("用户 ( "+user.getPhone()+" ) 已存在");
        }
        String salt = MD5.getRandomSalt();
        System.out.println("============= 注册盐值 = "+salt);
        System.out.println("============= 注册密码 = "+user.getPassword());
        String password = MD5.getEncrpytedPassword(user.getPassword(),salt);
        System.out.println("============= 注册密码加盐 = "+password);
        user.setPassword(password);
        user.setSalt(salt);
        Integer integer = userDAO.insertUserInfo(user);
        if (integer != 1){
            throw new InsertDataException("网络异常，注册信息失败！");
        }
    }

    @Override
    public User login(String phone, String password) throws UserNotFoundException, PasswordNotMatchException {
        List<User> users = userDAO.selectByPhone(phone);
        if(users.size() == 1){
            User user = users.get(0);
            String salt = user.getSalt();
            System.out.println("=================salt  "+salt);
            password = MD5.getEncrpytedPassword(password,salt);
            System.out.println("=================输入密码  "+password);
            System.out.println("=================数据库密码  "+user.getPassword());
            if(password.equals(user.getPassword())){
                return user;
            }else {
                throw new PasswordNotMatchException("密码错误，请重新输入！");
            }
        }else{
            throw new UserNotFoundException("用户名不存在，请重新输入！");
        }
    }





}
