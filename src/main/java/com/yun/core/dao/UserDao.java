package com.yun.core.dao;

import com.yun.core.model.TUser;


/**
 * Created by Administrator on 2018\3\20 0020.
 */
public interface UserDao {
    public TUser selectUserByName(TUser tUser);
}
