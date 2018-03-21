package com.yun.framework.util;


import com.yun.core.model.TUser;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户登录
 */
public class VerificationLoginUtil {

    private static  final  String SESSION_ID = "session_id";

    /**
     * 实现用户登录
     * @param session
     * @param resp
     * @param user
     */
    public static   void userLoginTools (HttpSession session, HttpServletResponse resp, TUser user) {

        //// 令牌
        String authCustomerCode = GeneratePrimaryKeyStrategy.authCustomerCode();

        // 在session 中存值
        session.setAttribute(authCustomerCode,user);
        // 返回令牌
        CookieUtil.addCookie(resp,SESSION_ID,authCustomerCode, 30 * 60);
    }
}
