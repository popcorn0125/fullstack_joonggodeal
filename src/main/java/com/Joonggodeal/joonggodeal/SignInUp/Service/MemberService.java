package com.Joonggodeal.joonggodeal.SignInUp.Service;


import com.Joonggodeal.joonggodeal.SignInUp.DTO.MemberDTO;
import com.Joonggodeal.joonggodeal.SignInUp.Dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;

/*******************
 * 날짜 : 2024.07.15
 * 이름 : 김준식
 * 내용 : 회원 서비스
 * *****************/
@Service
public class MemberService {
    @Autowired
    MemberDao memberDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    /*******************
     * 날짜 : 2024.07.15
     * 이름 : 김준식
     * 내용 : 회원가입 ( 비밀번호 암호화 후 저장)
     * *****************/
    public HashMap<String, Object> memberRegister(MemberDTO params) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("result", "0");
        try {
            String pw = passwordEncoder.encode(params.getPw());
            params.setPw(pw);
            int isSuccess = memberDao.memberRegister(params);
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
            result = memberDao.isDuplicateId(params);
        } catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    /*******************
     * 날짜 : 2024.07.15
     * 이름 : 김준식
     * 내용 : 닉네임 중복 확인
     * *****************/
    public int isDuplicateNickName(HashMap<String, Object> params) {
        int result = 0;
        try{
            result = memberDao.isDuplicateNickName(params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /*******************
     * 날짜 : 2024.07.29
     * 이름 : 김준식
     * 내용 : 마이페이지에서 회원 정보 불러오기
     * *****************/
    public HashMap<String, Object> loadUserInfo(HashMap<String, Object> params) throws SQLException {
        return memberDao.loadUserInfo(params);
    }

    /*******************
     * 날짜 : 2024.08.01
     * 이름 : 김준식
     * 내용 : 정보수정페이지에 필요한 회원정보 불러오기
     * *****************/
    public HashMap<String, Object> getUserInfo(HashMap<String, Object> params) throws SQLException {
        return memberDao.getUserInfo(params);
    }

    /*******************
     * 날짜 : 2024.08.02
     * 이름 : 김준식
     * 내용 : 정보수정에서 회원정보 수정하기
     * *****************/
    public int updateUserInfo(HashMap<String, Object> params) throws SQLException {
        String pw = params.get("member_password").toString();
        if(pw != null && !pw.equals("")) {
            String encodPW = passwordEncoder.encode(pw);
            params.put("member_password",encodPW);
        }
        return memberDao.updateUserInfo(params);
    }

    /*******************
     * 날짜 : 2024.08.01
     * 이름 : 김준식
     * 내용 : 회원탈퇴
     * *****************/
    public int deleteAccount(HashMap<String, Object> params) throws SQLException {
        return memberDao.deleteAccount(params);
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
        String userID = memberDao.findByID(params);

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
        int count = memberDao.findByPW(userID, phonenumber);
        return count > 0;
    }

    /*******************
     * 날짜 : 2024.08.05
     * 이름 : 권지용
     * 내용 : 비밀번호 재설정
     * *****************/
    public boolean updatePassword(String userID, String newPassword) {
        try {
            memberDao.updatePassword(userID, passwordEncoder.encode(newPassword));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
