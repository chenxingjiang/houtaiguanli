package com.yun.framework.exception.handler;

import com.yun.framework.common.costant.ExceptionContext;
import com.yun.framework.common.costant.HttpRequestConstant;
import com.yun.framework.exception.GlobalException;
import com.yun.framework.util.JsonUtil;
import com.yun.framework.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018\3\20 0020.
 * 全局异常处理器
 */
public class GlobalExceptionHandler implements HandlerExceptionResolver {

    //日志打印
    private static final Logger LOGGER  =  LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object hander, Exception e) {
        ModelAndView modelAndView = new ModelAndView();


        //判断异常类型
        if(hander instanceof HandlerMethod){
            GlobalException globalException = null;
            //获取拦截到的方法对象
            HandlerMethod handlerMethod = (HandlerMethod) hander;

            if(e instanceof GlobalException){
               globalException= (GlobalException) e;
            }else {
                if(LOGGER.isErrorEnabled()) {
                    LOGGER.error("未知异常:异常的原因为{}", e.getMessage());
                }
                    globalException= (GlobalException) e;
                    globalException.setMsg(ExceptionContext.UNKNOW_EX_MSG);
                    globalException.setCode(ExceptionContext.DEFUALT_EX_CODE);
            }

            Result result = new Result();
            result.setCode(globalException.getCode());
            result.setMsg(globalException.getMsg());
            boolean flag =  HttpRequestConstant.AJAX_XMLHTTPREQUEST
                    .equals(request.getHeader(HttpRequestConstant.HTTP_REQUESTED_WITH));

            Method method = handlerMethod.getMethod();
            ResponseBody an = method.getAnnotation(ResponseBody.class);

            if (flag || an != null) {//说明 异常信息 json 返回
                String json = JsonUtil.parseObjectToString(result);
                JsonUtil.write(response,json);
            }else {
                modelAndView.setViewName("error");
                modelAndView.addObject("error",result.getMsg());
            }
        }

        return null;
    }
}
