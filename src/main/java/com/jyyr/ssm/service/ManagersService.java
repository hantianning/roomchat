package com.jyyr.ssm.service;

import com.jyyr.ssm.entity.Managers;
import com.jyyr.ssm.service.ex.PasswordNotMatchException;
import com.jyyr.ssm.service.ex.UserNotFoundException;

public interface ManagersService {


    Managers logManager(String phone, String password) throws UserNotFoundException, PasswordNotMatchException;
}
