package com.jyyr.ssm.dao;

import com.jyyr.ssm.entity.Managers;

import java.util.List;

public interface ManagersDAO {


    List<Managers> selectManagerByPhone(String managerphone);
}
