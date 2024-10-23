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

/*******************
 * 날짜 : 2024.07.15
 * 이름 : 김준식
 * 내용 : 회원 컨트롤러
 * *****************/

@RestController
@RequestMapping("/api")
public class MemberController {

    @Autowired
    MemberService memberService;

    /*******************
     * 날짜 : 2024.07.15
     * 이름 : 김준식
     * 내용 : 회원가입
     * *****************/
    @PostMapping("/signup")
    public ResponseEntity<HashMap<String, Object>> memberRegister(@RequestBody HashMap<String, String> params) {
        System.out.println("memberRegister 실행");
        MemberDTO memberDTO = new MemberDTO(
                params.get("userid"),
                params.get("pw"),
                params.get("name"),
                params.get("phonenumber"),
                params.get("nickname"),
                params.get("gender").charAt(0)
        );
        return ResponseEntity.ok(memberService.memberRegister(memberDTO));
    }

    /*******************
     * 날짜 : 2024.07.16
     * 이름 : 김준식
     * 내용 : 아이디 중복 확인
     * *****************/
    @PostMapping("/isDuplicateId")
    public ResponseEntity<Integer> isDuplcateId(@RequestBody HashMap<String, Object> params) {
        System.out.println("isDuplicateId 실행");
        return ResponseEntity.ok(memberService.isDuplicateId(params));
    }

    /*******************
     * 날짜 : 2024.07.16
     * 이름 : 김준식
     * 내용 : 닉네임 중복 확인
     * *****************/
    @PostMapping("/isDuplicateNickName")
    public ResponseEntity<Integer> isDuplicateNickName(@RequestBody HashMap<String, Object> params) {
        System.out.println("isDuplicateNickName 실행");
        return ResponseEntity.ok(memberService.isDuplicateNickName(params));
    }

    /*******************
     * 날짜 : 2024.07.29
     * 이름 : 김준식
     * 내용 : 마이페이지에서 회원 정보 불러오기
     * *****************/
    @PostMapping("/loadUserInfo")
    public ResponseEntity<HashMap<String, Object>> loadUserInfo(@RequestBody HashMap<String, Object> params) throws SQLException {
        System.out.println("loadUserInfo 실행");
        return ResponseEntity.ok(memberService.loadUserInfo(params));
    }

    /*******************
     * 날짜 : 2024.08.01
     * 이름 : 김준식
     * 내용 : 정보수정에서 회원 정보 불러오기
     * *****************/
    @PostMapping("/getUserInfo")
    public ResponseEntity<HashMap<String, Object>> getUserInfo(@RequestBody HashMap<String, Object> params) throws SQLException {
        System.out.println("getUserInfo 실행");
        return ResponseEntity.ok(memberService.getUserInfo(params));
    }

    /*******************
     * 날짜 : 2024.08.02
     * 이름 : 김준식
     * 내용 : 정보수정에서 회원정보 수정하기
     * *****************/
    @PostMapping("/updateUserInfo")
    public ResponseEntity<Integer> updateUserInfo(@RequestBody HashMap<String, Object> params) throws SQLException {
        System.out.println("updateUserInfo 실행");
        return ResponseEntity.ok(memberService.updateUserInfo(params));
    }

    /*******************
     * 날짜 : 2024.08.01
     * 이름 : 김준식
     * 내용 : 회원탈퇴
     * *****************/
    @PostMapping("/deleteAccount")
    public ResponseEntity<Integer> deleteAccount(@RequestBody HashMap<String, Object> params) throws SQLException {
        System.out.println("deleteAccount 실행");
        return ResponseEntity.ok(memberService.deleteAccount(params));
    }

    /*******************
     * 날짜 : 2024.08.05
     * 이름 : 권지용
     * 내용 : 아이디 찾기
     * *****************/
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

    /*******************
     * 날짜 : 2024.08.05
     * 이름 : 권지용
     * 내용 : 비밀번호 찾기
     * *****************/
    @PostMapping("/findByPW")
    public ResponseEntity<HashMap<String, Object>> findByPW(@RequestBody HashMap<String, Object> params) {
        String userID = (String) params.get("userID");
        String phonenumber = (String) params.get("phonenumber");

        boolean userExists = memberService.checkUserExists(userID, phonenumber);

        HashMap<String, Object> response = new HashMap<>();
        response.put("userExists", userExists);

        return ResponseEntity.ok(response);
    }

    /*******************
     * 날짜 : 2024.08.05
     * 이름 : 권지용
     * 내용 : 비밀번호 재설정
     * *****************/
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
