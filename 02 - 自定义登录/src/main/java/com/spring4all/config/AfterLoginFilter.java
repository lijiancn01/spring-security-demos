package com.spring4all.config;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @Desciption TODO
 * @Author jian.li
 * @Date 2019/10/14
 * @Version 1.0
 **/
public class AfterLoginFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("########  after ");
        // 继续调用 Filter 链
        chain.doFilter(request, response);
    }
}
