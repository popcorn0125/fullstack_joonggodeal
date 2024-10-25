package com.Joonggodeal.joonggodeal.SignInUp.Controller;


import com.Joonggodeal.joonggodeal.SignInUp.Service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.HashMap;

@RestController
@RequestMapping("/memberLogin")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/verify")
    public ResponseEntity<HashMap<String, Object>> login(@RequestBody HashMap<String, Object> params, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("login Controller 실행");
        return ResponseEntity.ok(loginService.smartLicenselogin(params, request, response));
    }

    @PostMapping("/logout")
    public ResponseEntity<Integer> logout(HttpServletRequest request) {
        System.out.println("logout 실행");
        return ResponseEntity.ok(loginService.logout(request));
    }

    @PostMapping("/guestLogin")
    public ResponseEntity<HashMap<String, Object>> guestLogin() {
        System.out.println("guestLogin 실행");
        return ResponseEntity.ok(loginService.guestLogin());
    }

    @PostMapping("/userPWCheck")
    public ResponseEntity<HashMap<String, Object>> userPWCheck(@RequestBody HashMap<String, Object> params) throws SQLException {
        System.out.println("userPWCheck 실행");
        System.out.println("params : " + params);
        return ResponseEntity.ok(loginService.userPWCheck(params));
    }
}
