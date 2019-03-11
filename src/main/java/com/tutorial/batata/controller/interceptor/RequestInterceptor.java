package com.tutorial.batata.controller.interceptor;

import org.slf4j.MDC;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * An interceptor to add a correlation-id on logback; this will put a [correlation-id] value on all logs;
 */
public class RequestInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object object) {

        MDC.put("correlation", getCorrelation(request));

        return true;
    }

    private String getCorrelation(final HttpServletRequest request) {
        String id = request.getHeader("correlation-id");
        return  id != null ? id : UUID.randomUUID().toString();
    }
}
