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

@RestController
@RequestMapping("/adminlogin")
public class AdminLoginController {

    @Autowired
    AdminLoginService adminLoginService;


    @PostMapping("/verify")
    public ResponseEntity<HashMap<String, Object>> login(@RequestBody HashMap<String, Object> params, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("login Controller 실행");
        return ResponseEntity.ok(adminLoginService.smartLicenselogin(params, request, response));
    }


    @PostMapping("/logout")
    public ResponseEntity<Integer> logout(HttpServletRequest request) {
        System.out.println("logout 실행");
        return ResponseEntity.ok(adminLoginService.logout(request));
    }




    @PostMapping("/userPWCheck")
    public ResponseEntity<HashMap<String, Object>> userPWCheck(@RequestBody HashMap<String, Object> params) throws SQLException {
        System.out.println("userPWCheck 실행");
        System.out.println("params : " + params);
        return ResponseEntity.ok(adminLoginService.userPWCheck(params));
    }
}
