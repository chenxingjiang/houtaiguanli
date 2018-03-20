package com.yun.biz.controller;

import com.yun.biz.service.UserService;
import com.yun.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018\3\20 0020.
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("get/{id}")
    public User get(@PathVariable("id") Integer id){
        return userService.get(id);
    }

}
