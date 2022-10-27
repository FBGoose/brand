package com.itheima.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description
 *
 *  替换HttpServlet 根据请求的最后一段路径来进行方法分发
 *
 * @data Created in 2022-10-22 14:05
 */
public class BaseServlet extends HttpServlet {

    //根据请求的最后一段路径来进行方法分发
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求路径
        String uri = request.getRequestURI();  // /brand/brand/selectAll

        //2.获取最后一段路径 也就是方法名
        int index = uri.lastIndexOf("/");  // /selectAll
        String methodName = uri.substring(index+1);  // selectAll

        //3.执行方法
        //this 谁调用我(this所在的方法 service) 我(this)代表谁 此刻代表BrandServlet UserServlet 即BaseServlet的子类
        //3.1 获取 .class 字节码对象
        Class<? extends BaseServlet> cls = this.getClass();

        //3.2 获取方法 Method对象
        try {
            Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //3.3 执行方法
            method.invoke(this,request,response);

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }
}
