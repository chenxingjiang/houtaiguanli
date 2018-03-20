package com.yun.biz.service.imp;

import com.yun.biz.service.UserService;
import com.yun.core.dao.UserDao;
import com.yun.core.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018\3\20 0020.
 */

@Service
public class UserServiceImp implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User get(int id) {
        return userDao.get(id);
    }
}
