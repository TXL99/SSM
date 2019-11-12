package com.xkit.textssm.interceptors;

import com.xkit.textssm.entity.Easybuy_user;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

/**
 * 拦截器跳转的地方
 */
public class interceptorTest implements HandlerInterceptor {
    private Logger logger=Logger.getLogger("interceptorTest.class");
    //后端控制器方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
         HttpSession session=httpServletRequest.getSession();
        Easybuy_user user= (Easybuy_user)session.getAttribute("userSession");
        if(user!=null){
             return true;
        }

        httpServletRequest.setAttribute("ts","您还没有登录，请先登录!");
        httpServletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest,httpServletResponse);
        return false;
    }

    //后端控制器方法执行之后 视图解析器之前
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    //视图解析器之后
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
