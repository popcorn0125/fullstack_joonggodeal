package com.Joonggodeal.joonggodeal.Admin.Notice.Controller;

import com.Joonggodeal.joonggodeal.Admin.Notice.Service.AdminNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/adminnotice")
@RequiredArgsConstructor
public class AdminNoticeController {
    AdminNoticeService adminNoticeService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody HashMap<String, Object> params) {
        System.out.println("AdminNoticeController - 실행 - register");
        return ResponseEntity.ok(adminNoticeService.register(params));
    }

    @PostMapping("/getnoticelist")
    public ResponseEntity<?> getNoticeAll(@RequestBody HashMap<String, Object> params) {
        System.out.println("AdminNoticeController - 실행 - getNoticeAll");
        return ResponseEntity.ok(adminNoticeService.getNoticeAll(params));
    }

    @PostMapping("/oneNotice")
    public ResponseEntity<?> getOneNotice(@RequestBody HashMap<String, Object> params) {
        System.out.println("AdminNoticeController - 실행 - getOneNotice");
        return ResponseEntity.ok(adminNoticeService.getOneNotice(params));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> noticeDelete(@RequestBody HashMap<String, Object> params) {
        System.out.println("AdminNoticeController - 실행 - noticeDelete");
        adminNoticeService.noticeDelete(params);
        return ResponseEntity.ok(200);
    }
}
