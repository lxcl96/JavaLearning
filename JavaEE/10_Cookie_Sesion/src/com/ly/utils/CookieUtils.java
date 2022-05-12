package com.ly.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author : Ly
 * @Date : 2022/5/7
 * @Description : Cookie工具类
 */
public class CookieUtils {

    /**
     * 查找指定名称的cookie对象
     * @param request HttpServletRequest请求
     * @param cookieName 想要找到的cookie的name值
     * @return 返回查找的cookie对象，如果没找到返回null
     */
    public static Cookie getCookie(HttpServletRequest request,String cookieName) {
        assert cookieName != null:"参数 cookieName不能为空！";
        Cookie targetCookie = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookieName.equals(cookie.getName())) {
                targetCookie = cookie;
                break;
            }
        }

        return targetCookie;
    }
}
