package com.yun.core.dao;

import com.yun.core.model.User;


/**
 * Created by Administrator on 2018\3\20 0020.
 */
public interface UserDao {
    public User selectUserByName(String userName);
}
