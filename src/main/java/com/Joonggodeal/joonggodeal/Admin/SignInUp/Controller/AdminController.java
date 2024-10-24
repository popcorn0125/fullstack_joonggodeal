package com.Joonggodeal.joonggodeal.Admin.SignInUp.Controller;

import com.Joonggodeal.joonggodeal.Admin.SignInUp.DTO.AdminDTO;
import com.Joonggodeal.joonggodeal.Admin.SignInUp.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*******************
 * 날짜 : 2024.07.15
 * 이름 : 김준식
 * 내용 : 회원 컨트롤러
 * *****************/

@RestController
@RequestMapping("/adminpost")
public class AdminController {

    @Autowired
    AdminService adminService;

    /*******************
     * 날짜 : 2024.07.15
     * 이름 : 김준식
     * 내용 : 회원가입
     * *****************/
    @PostMapping("/register")
    public ResponseEntity<HashMap<String, Object>> memberRegister(@RequestBody HashMap<String, String> params) {
        System.out.println("memberRegister 실행");
        AdminDTO adminDTO = new AdminDTO(
                params.get("id"),
                params.get("pw"),
                params.get("name"),
                params.get("email")
        );
        return ResponseEntity.ok(adminService.memberRegister(adminDTO));
    }

    /*******************
     * 날짜 : 2024.07.16
     * 이름 : 김준식
     * 내용 : 아이디 중복 확인
     * *****************/
    @PostMapping("/isDuplicateId")
    public ResponseEntity<Integer> isDuplcateId(@RequestBody HashMap<String, Object> params) {
        System.out.println("isDuplicateId 실행");
        return ResponseEntity.ok(adminService.isDuplicateId(params));
    }



    /*******************
     * 날짜 : 2024.08.01
     * 이름 : 김준식
     * 내용 : 회원탈퇴
     * *****************/
    @PostMapping("/deleteAccount")
    public ResponseEntity<Integer> deleteAccount(@RequestBody HashMap<String, Object> params) throws SQLException {
        System.out.println("deleteAccount 실행");
        return ResponseEntity.ok(adminService.deleteAccount(params));
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
        HashMap<String, Object> response = adminService.findByID(userName, phoneNumber);

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

        boolean userExists = adminService.checkUserExists(userID, phonenumber);

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

        boolean updateSuccess = adminService.updatePassword(userID, newPassword);
        if (updateSuccess) {
            return ResponseEntity.ok("Password updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update password.");
        }
    }

    /*******************
     * 날짜 : 2024.10.25
     * 이름 : 김준식
     * 내용 : 모든 회원 정보 불러오기
     * *****************/
    @PostMapping("/getusers")
    public ResponseEntity<List<HashMap<String, Object>>> getUsers() {
        System.out.println("AdminController 실행 - getUsers");
        return ResponseEntity.ok(adminService.getUsers());
    }

    @PostMapping("/deleteuser")
    public ResponseEntity<Integer> deleteUser(@RequestBody HashMap<String, Object> params) {
        System.out.println("AdminController 실행 - deleteUsers");
        return ResponseEntity.ok(adminService.deleteUsers(params));
    }
}
