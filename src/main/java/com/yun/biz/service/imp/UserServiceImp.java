package com.yun.biz.service.imp;

import com.yun.biz.service.UserService;
import com.yun.core.dao.UserDao;
import com.yun.core.model.TUser;
import com.yun.core.paramemodel.ParameUser;
import com.yun.framework.util.Md5Util;
import com.yun.framework.util.Result;
import com.yun.framework.util.StringUtil;
import com.yun.framework.util.VerificationLoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018\3\20 0020.
 */

@Service
public class UserServiceImp implements UserService {

    @Autowired(required = false)
    private HttpSession session;

    @Autowired(required = false)
    private HttpServletResponse resp;

    @Resource
    private UserDao userDao;

    @Override
    public Result userLogin(ParameUser parameUser) {
        if(StringUtil.isEmpty(parameUser.getUserName())||StringUtil.isEmpty(parameUser.getUserPwd())){
            return Result.fail("用户名或密码不能为空!");
        }

        TUser user = userDao.selectUserByName(parameUser.getUserName());
        if(user == null || user.getUserPwd().equals(Md5Util.encode(userPwd))){
            return Result.fail("用户名或密码错误!");
        }

        //登录成功
        VerificationLoginUtil.userLoginTools(session,resp,user);


        return null;
    }
}
