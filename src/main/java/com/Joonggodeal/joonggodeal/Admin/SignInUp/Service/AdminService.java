package com.Joonggodeal.joonggodeal.Admin.SignInUp.Service;


import com.Joonggodeal.joonggodeal.Admin.SignInUp.DTO.AdminDTO;
import com.Joonggodeal.joonggodeal.Admin.SignInUp.Dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/*******************
 * 날짜 : 2024.07.15
 * 이름 : 김준식
 * 내용 : 회원 서비스
 * *****************/
@Service
public class AdminService {
    @Autowired
    AdminDao adminDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    /*******************
     * 날짜 : 2024.07.15
     * 이름 : 김준식
     * 내용 : 회원가입 ( 비밀번호 암호화 후 저장)
     * *****************/
    public HashMap<String, Object> memberRegister(AdminDTO params) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("result", "0");
        try {
            String pw = passwordEncoder.encode(params.getPw());
            params.setPw(pw);
            int isSuccess = adminDao.memberRegister(params);
            if (isSuccess != 0) result.put("result", "1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /*******************
     * 날짜 : 2024.07.16
     * 이름 : 김준식
     * 내용 : 아이디 중복 확인
     * *****************/
    public int isDuplicateId(HashMap<String, Object> params) {
        int result = 0;
        try{
            result = adminDao.isDuplicateId(params);
        } catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }



    /*******************
     * 날짜 : 2024.08.01
     * 이름 : 김준식
     * 내용 : 회원탈퇴
     * *****************/
    public int deleteAccount(HashMap<String, Object> params) throws SQLException {
        return adminDao.deleteAccount(params);
    }

    /*******************
     * 날짜 : 2024.08.05
     * 이름 : 권지용
     * 내용 : 아이디 찾기
     * *****************/
    public HashMap<String, Object> findByID(String userName, String phoneNumber) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("userName", userName);
        params.put("phonenumber", phoneNumber);

        // 사용자 ID를 조회
        String userID = adminDao.findByID(params);

        // 결과를 담을 해시맵
        HashMap<String, Object> response = new HashMap<>();
        if (userID != null) {
            response.put("userID", userID);
        } else {
            response.put("error", "User not found");
        }

        return response;
    }

    public boolean checkUserExists(String userID, String phonenumber) {
        int count = adminDao.findByPW(userID, phonenumber);
        return count > 0;
    }

    /*******************
     * 날짜 : 2024.08.05
     * 이름 : 권지용
     * 내용 : 비밀번호 재설정
     * *****************/
    public boolean updatePassword(String userID, String newPassword) {
        try {
            adminDao.updatePassword(userID, passwordEncoder.encode(newPassword));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<HashMap<String, Object>> getUsers() {
        return adminDao.getUsers();
    }

    public int deleteUsers(HashMap<String, Object> params) {
        return adminDao.deleteUsers(params);
    }
}
