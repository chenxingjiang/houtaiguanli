package com.yun.framework.exception;

import com.yun.framework.common.costant.ExceptionContext;
import lombok.Getter;
import lombok.Setter;


/**
 * Created by Administrator on 2018\3\20 0020.
 */

@Getter
@Setter
public class GlobalException extends RuntimeException {

    private String code;//异常状态码

    private String msg;//异常信息


    public static GlobalException fail(String msg){
        GlobalException ge = new GlobalException();
        ge.setCode(ExceptionContext.DEFUALT_EX_CODE);
        ge.setMsg(msg);
        return ge;
    }

    public static GlobalException fail(String msg,String code){

        GlobalException ge = new GlobalException();
        ge.setCode(code);
        ge.setMsg(msg);
        return ge;
    }

    public static GlobalException failUnknowException(){
        GlobalException ge = new GlobalException();
        ge.setCode(ExceptionContext.DEFUALT_EX_CODE);
        ge.setMsg(ExceptionContext.UNKNOW_EX_MSG);
        return ge;
    }

    public static GlobalException failNetException(){
        GlobalException ge = new GlobalException();
        ge.setCode(ExceptionContext.DEFUALT_EX_CODE);
        ge.setMsg(ExceptionContext.DEFUALT_EX_MSG);
        return ge;
    }


}
