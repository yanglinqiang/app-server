package com.cake.server.interceptor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RecordLogInterceptor extends HandlerInterceptorAdapter {

    public final static Logger logger = LoggerFactory.getLogger(RecordLogInterceptor.class.getName());


    /**
     * 记录方法调用的起始时间
     */
    private static ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    /**
     * 调用controller之前调用
     *
     * @return 如果为真则继续执行请求的方法, 如果为false则该请求将被阻断, 不会执行相应的controller方法
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        startTime.set(System.currentTimeMillis());// 记录当前时间
        return true;
    }

    /**
     * 调用controller之后调用做日志记录用
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        String url = request.getServletPath();
        Long endTime = System.currentTimeMillis();// 记下结束时间
        Long sTime = startTime.get();
        if (sTime != null) {
            String logDoTime = "===============[" + url + "] 用时["
                    + (endTime - sTime) + "]ms";
            logger.info(logDoTime);
        }
        startTime.remove();// 释放
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

}
