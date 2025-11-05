package org.example.state.util;

import jakarta.servlet.http.Cookie;

public class CookieUtil {
    public static Cookie createCookie(String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        cookie.setHttpOnly(true); // JS의 접근 X
        return cookie;
    }

    // Name -> Cookie
    public static Cookie findCookie(Cookie[] cookies, String name) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    // Name -> Cookie -> 삭제
    public static Cookie deleteCookie(String name) {
        Cookie cookie = new Cookie(name, "");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        return cookie;
    }
}