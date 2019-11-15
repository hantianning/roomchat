package com.jyyr.ssm.service.impl;

import com.jyyr.ssm.dao.ManagersDAO;
import com.jyyr.ssm.entity.Managers;
import com.jyyr.ssm.service.ManagersService;
import com.jyyr.ssm.service.ex.PasswordNotMatchException;
import com.jyyr.ssm.service.ex.UserNotFoundException;
import com.jyyr.ssm.tools.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("managersService")
public class ManagersServiceImpl implements ManagersService {

    @Autowired
    private ManagersDAO managersDAO;

    @Override
    public Managers logManager(String managerphone, String managerpassword) throws UserNotFoundException, PasswordNotMatchException {
        List<Managers> managers = managersDAO.selectManagerByPhone(managerphone);
        if(managers.size() == 1){
            Managers manager = managers.get(0);
            String salt = manager.getSalt();
            System.out.println("=================salt  "+salt);
            managerpassword = MD5.getEncrpytedPassword(managerpassword,salt);
            if(managerpassword.equals(manager.getManagerpassword())){
                return manager;
            }else{
                throw new PasswordNotMatchException("密码错误！");
            }
        }else{
            throw new UserNotFoundException("该管理员不存在！");
        }
    }



}
