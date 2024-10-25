package com.Joonggodeal.joonggodeal.SignInUp.Controller;

import com.Joonggodeal.joonggodeal.SignInUp.DTO.MemberDTO;
import com.Joonggodeal.joonggodeal.SignInUp.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<HashMap<String, Object>> memberRegister(@RequestBody HashMap<String, String> params) {
        System.out.println("memberRegister 실행");
        MemberDTO memberDTO = new MemberDTO(
                params.get("userid"),
                params.get("pw"),
                params.get("name"),
                params.get("nickname")
        );
        return ResponseEntity.ok(memberService.memberRegister(memberDTO));
    }

    @PostMapping("/isDuplicateId")
    public ResponseEntity<Integer> isDuplcateId(@RequestBody HashMap<String, Object> params) {
        System.out.println("isDuplicateId 실행");
        return ResponseEntity.ok(memberService.isDuplicateId(params));
    }

    @PostMapping("/isDuplicateNickName")
    public ResponseEntity<Integer> isDuplicateNickName(@RequestBody HashMap<String, Object> params) {
        System.out.println("isDuplicateNickName 실행");
        return ResponseEntity.ok(memberService.isDuplicateNickName(params));
    }

    @PostMapping("/loadUserInfo")
    public ResponseEntity<HashMap<String, Object>> loadUserInfo(@RequestBody HashMap<String, Object> params) throws SQLException {
        System.out.println("loadUserInfo 실행");
        return ResponseEntity.ok(memberService.loadUserInfo(params));
    }

    @PostMapping("/getUserInfo")
    public ResponseEntity<HashMap<String, Object>> getUserInfo(@RequestBody HashMap<String, Object> params) throws SQLException {
        System.out.println("getUserInfo 실행");
        return ResponseEntity.ok(memberService.getUserInfo(params));
    }

    @PostMapping("/updateUserInfo")
    public ResponseEntity<Integer> updateUserInfo(@RequestBody HashMap<String, Object> params) throws SQLException {
        System.out.println("updateUserInfo 실행");
        return ResponseEntity.ok(memberService.updateUserInfo(params));
    }

    @PostMapping("/deleteAccount")
    public ResponseEntity<Integer> deleteAccount(@RequestBody HashMap<String, Object> params) throws SQLException {
        System.out.println("deleteAccount 실행");
        return ResponseEntity.ok(memberService.deleteAccount(params));
    }

    @PostMapping("/findByID")
    public ResponseEntity<HashMap<String, Object>> findByID(@RequestBody HashMap<String, Object> params) {
        String userName = (String) params.get("userName");
        String phoneNumber = (String) params.get("phonenumber");

        // 사용자 ID를 조회
        HashMap<String, Object> response = memberService.findByID(userName, phoneNumber);

        if (response.containsKey("error")) {
            // 사용자 정보를 찾을 수 없는 경우
            return ResponseEntity.status(404).body(response);
        } else {
            // 사용자 정보를 찾은 경우
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping("/findByPW")
    public ResponseEntity<HashMap<String, Object>> findByPW(@RequestBody HashMap<String, Object> params) {
        String userID = (String) params.get("userID");
        String phonenumber = (String) params.get("phonenumber");

        boolean userExists = memberService.checkUserExists(userID, phonenumber);

        HashMap<String, Object> response = new HashMap<>();
        response.put("userExists", userExists);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/resetPassword")
    public ResponseEntity<String> resetPassword(@RequestBody Map<String, Object> params) {
        String userID = (String) params.get("userID");
        String newPassword = (String) params.get("newPassword");

        boolean updateSuccess = memberService.updatePassword(userID, newPassword);
        if (updateSuccess) {
            return ResponseEntity.ok("Password updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update password.");
        }
    }
}
