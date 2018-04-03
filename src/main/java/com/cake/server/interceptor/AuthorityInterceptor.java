package com.cake.server.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AuthorityInterceptor extends HandlerInterceptorAdapter {


    public final static Logger logger = LoggerFactory.getLogger(RecordLogInterceptor.class.getName());

    /**
     * 调用controller之前调用
     *
     * @return 如果为真则继续执行请求的方法, 如果为false则该请求将被阻断, 不会执行相应的controller方法
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        //对参数进行验证
//        return this.verifyParams(request);
        return true;
    }

    /**
     * 调用controller之后调用做日志记录用
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}
