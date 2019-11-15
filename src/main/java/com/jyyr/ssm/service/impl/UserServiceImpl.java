package com.jyyr.ssm.service.impl;

import com.jyyr.ssm.dao.UserDAO;
import com.jyyr.ssm.entity.User;
import com.jyyr.ssm.service.UserService;
import com.jyyr.ssm.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.UUID;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;


    @Override
    public void registUser(User user) throws PhoneConflictException, InsertDataException {
        List<User> userB = userDAO.selectByPhone(user.getPhone());
        if(userB.size() > 0){
            throw new PhoneConflictException("用户 ( "+user.getPhone()+" ) 已存在");
        }
        String salt = getRandomSalt();
        System.out.println("============= 注册盐值 = "+salt);
        System.out.println("============= 注册密码 = "+user.getPassword());
        String password = getEncrpytedPassword(user.getPassword(),salt);
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
        if(users.size() > 0){
            User user = users.get(0);
            String salt = user.getSalt();
            System.out.println("=================salt  "+salt);
            password = getEncrpytedPassword(password,salt);
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

    @Override
    public User logManager(String phone, String password) throws UserNotFoundException, PasswordNotMatchException {
        List<User> users = userDAO.selectManagerByPhone(phone);
        if(users.size() > 0){
            User user = users.get(0);
            String salt = user.getSalt();
            System.out.println("=================salt  "+salt);
            password = getEncrpytedPassword(password,salt);
            if(password.equals(user.getPassword())){
                return user;
            }else {
                throw new PasswordNotMatchException("密码错误！");
            }
        }else{
            throw new UserNotFoundException("该管理员不存在！");
        }
    }


    /**
     * 对密码进行加密
     *
     * @param salt 盐值
     * @param src 原文
     * @return 加密后密码
     */
    private static String getEncrpytedPassword(String src, String salt) {
        // 将原密码加密
        String s1 = md5(src);
        // 再将盐加密
        String s2 = md5(salt);
        // 将2次加密结果拼接，在加密
        String s3 = s1 + s2;
        String result = md5(s3);
        // 将以上结果在加密5次
        for (int i = 0; i < 5; i++) {
            result = md5(result);
        }
        return result;
    }

    /**
     * 获取随机的盐值
     *
     * @return 盐
     */
    private static String getRandomSalt() {
        return UUID.randomUUID().toString().toUpperCase();
    }

    /**
     * 使用md5算法对数据进行加密
     *
     * @param src 原文
     * @return 密文
     */
    private static String md5(String src) {
        return DigestUtils.md5DigestAsHex(src.getBytes()).toUpperCase();
    }


    public static void main(String[] args) {
        String password = "qwe123";
        String salt = getRandomSalt();
        System.out.println("managersalt = "+salt);
        password = getEncrpytedPassword(password,salt);
        System.out.println("加密后的密码 = "+password);
        /*managersalt = 56233497-1483-4BE9-9A11-D0CD4C0F8A93
        加密后的密码 = DF49395959305B413B66C56AF619CDE9*/
    }
}
