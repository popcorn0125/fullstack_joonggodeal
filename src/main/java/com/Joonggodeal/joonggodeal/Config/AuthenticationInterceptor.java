//package com.Joonggodeal.joonggodeal.Config;
//
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//public class AuthenticationInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("Incoming request: " + request.getRequestURI());
//        if(!checkAuthentication(request, response)) {
////            response.sendRedirect("/");
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return false;
//        }
//        return true;
//    }
//
//
//    public boolean checkAuthentication(HttpServletRequest request, HttpServletResponse response) {
//        HttpSession session = request.getSession(false);
//        if (session != null) {
//            session.setMaxInactiveInterval(24*60*60);
//            return true;
//        }
//        Cookie[] cookies = request.getCookies();
//        if(cookies != null) {
//            for( Cookie cookie : cookies) {
//                if(cookie.getName().equals("GUEST")){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//}
