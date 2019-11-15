package com.jyyr.ssm.dao;

import com.jyyr.ssm.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {

    /**
     * 插入用户数据
     * @param user 用户所有信息
     * @return
     */
    Integer insertUserInfo(User user);

    List<User> selectByUsername(String username);

    List<User> selectByPhone(String phone);


}
