package com.jyyr.ssm.service;


import com.jyyr.ssm.entity.User;
import com.jyyr.ssm.service.ex.*;


public interface UserService {

    /*注册新用户*/
    void registUser(User user) throws PhoneConflictException, InsertDataException;


    /*通过username，password登录*/
    User login(String phone,String password)throws UserNotFoundException, PasswordNotMatchException;


}
