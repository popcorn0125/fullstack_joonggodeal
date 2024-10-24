package com.Joonggodeal.joonggodeal.Admin.SignInUp.Controller;


import com.Joonggodeal.joonggodeal.Admin.SignInUp.Service.AdminLoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.HashMap;
/*******************
 * 날짜 : 2024.07.10
 * 이름 : 김준식
 * 내용 : login Controller
 * *****************/
@RestController
@RequestMapping("/adminlogin")
public class AdminLoginController {

    @Autowired
    AdminLoginService adminLoginService;

    /*******************
     * 날짜 : 2024.10.24
     * 이름 : 김준식
     * 내용 : 로그인
     * *****************/
    @PostMapping("/verify")
    public ResponseEntity<HashMap<String, Object>> login(@RequestBody HashMap<String, Object> params, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("login Controller 실행");
        return ResponseEntity.ok(adminLoginService.smartLicenselogin(params, request, response));
    }

    /*******************
     * 날짜 : 2024.07.29
     * 이름 : 김준식
     * 내용 : 로그아웃
     * *****************/
    @PostMapping("/logout")
    public ResponseEntity<Integer> logout(HttpServletRequest request) {
        System.out.println("logout 실행");
        return ResponseEntity.ok(adminLoginService.logout(request));
    }

    /*******************
     * 날짜 : 2024.07.28
     * 이름 : 김준식
     * 내용 : 게스트로그인
     * *****************/
//    @PostMapping("/guestLogin")
//    public ResponseEntity<HashMap<String, Object>> guestLogin() {
//        System.out.println("guestLogin 실행");
//        return ResponseEntity.ok(loginService.guestLogin());
//    }

    /*******************
     * 날짜 : 2024.07.29
     * 이름 : 김준식
     * 내용 : 사용자 비밀번호 일치 여부 확인
     * *****************/
    @PostMapping("/userPWCheck")
    public ResponseEntity<HashMap<String, Object>> userPWCheck(@RequestBody HashMap<String, Object> params) throws SQLException {
        System.out.println("userPWCheck 실행");
        System.out.println("params : " + params);
        return ResponseEntity.ok(adminLoginService.userPWCheck(params));
    }
}
