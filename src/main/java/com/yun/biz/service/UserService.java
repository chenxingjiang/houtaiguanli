package com.yun.biz.service;

import com.yun.framework.util.Result;

/**
 * Created by Administrator on 2018\3\20 0020.
 */
public interface UserService {
    public Result userLogin(String userName, String userPwd);
}
