package com.Joonggodeal.joonggodeal.SignInUp.Service;

import com.Joonggodeal.joonggodeal.SignInUp.Dao.LoginDao;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

/*******************
 * 날짜 : 2024.07.10
 * 이름 : 김준식
 * 내용 : login Service
 * *****************/
@Service
public class LoginService {

    @Autowired
    LoginDao loginDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    // RSA 키 생성
//    private final KeyPair keyPair;
//
//    public LoginService() throws NoSuchAlgorithmException {
//        this.keyPair = KeyGeneratorUtils.generateRSAKeyPair();
//    }

    /*******************
     * 날짜 : 2024.07.10
     * 이름 : 김준식
     * 내용 : 로그인(아이디, 비밀번호 검사)
     * *****************/
    public HashMap<String, Object> smartLicenselogin(HashMap<String, Object> params, HttpServletRequest request, HttpServletResponse response) {
        // 0 : 로그인 실패, 1 : 로그인 성공
        HashMap<String, Object> result = new HashMap<>();
        result.put("result",0);
        try {
            // 아이디 검증
            int count = loginDao.userIdCheck(params.get("userId").toString());
            if(count == 0) {
                result.put("message", "존재하지 않는 아이디입니다.");
                return result;
            }

            // 비밀번호 검증
            String password = params.get("userPw").toString();
            String encodePassword = loginDao.getUserPw(params);
            // 비밀번호가 일치하지 않을 경우
            if( !(passwordEncoder.matches(password, encodePassword)) ) {
                result.put("message", "비밀번호가 일치하지 않습니다.");
                return result;
            }


            HttpSession session = request.getSession();
            session.setAttribute("loginUser", params.get("userId").toString());
            session.setMaxInactiveInterval(24*60*60); // 24시간
            result.put("JSESSIONID", session.getId().toString());
            result.put("USER_ID", params.get("userId").toString());
//            cookieCreate(response, "JSESSIONID", session.getId());
//            cookieCreate(response, "USER_ID", params.get("userId").toString());

            result.put("result", 1);
            System.out.println("로그인 성공");
        } catch (Exception e){
            result.put("message", "오류가 발생하였습니다.");
            e.printStackTrace();
        }

        return result;
    }

    /*******************
     * 날짜 : 2024.07.17
     * 이름 : 김준식
     * 내용 : 쿠키 생성
     * *****************/
    public void cookieCreate(HttpServletResponse response, String cookieName, String cookieValue ) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(24*60*60); // 쿠키 수명 24시간 (시간*분*초)
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /*******************
     * 날짜 : 2024.07.17
     * 이름 : 김준식
     * 내용 : 로그아웃
     * *****************/
    public int logout(HttpServletRequest request) {
        int result = 0;

        HttpSession session = request.getSession(false);
        if (session != null) {
            // 세션 무효화
            session.invalidate();
            // 쿠키 삭제
            //cookieDelete(request, response);
            result = 1;
        }
        return result;
    }

    /*******************
     * 날짜 : 2024.07.10
     * 이름 : 김준식
     * 내용 : 쿠키 삭제
     * *****************/
    public void cookieDelete(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for( Cookie cookie : cookies) {
                if(cookie.getName().equals("JSESSIONID") || cookie.getName().equals("USER_ID")){
                    // 쿠키에 USER_ID가 있을 경우
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
            }
        }
    }

    /*******************
     * 날짜 : 2024.07.28
     * 이름 : 김준식
     * 내용 : 게스트 로그인(UUID를 생성하여 DB에 저장 후 front로 전달
     * *****************/
    public HashMap<String, Object> guestLogin() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("result", 0);
        try{
            String uuid = UUID.randomUUID().toString();
            int isSuccess = loginDao.guestLogin(uuid);
            if (isSuccess > 0) {
                result.put("result", 1);
                result.put("guestId", uuid);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    /*******************
     * 날짜 : 2024.07.29
     * 이름 : 김준식
     * 내용 : 사용자 비밀번호 일치 여부 확인
     * *****************/
    public HashMap<String, Object> userPWCheck(HashMap<String, Object> params) throws SQLException {
        // 0 : 비밀번호 불일치, 1 : 비밀번호 일치
        HashMap<String, Object> result = new HashMap<>();
        result.put("result",0);
        // 비밀번호 검증
        String password = params.get("userPw").toString();
        String encodePassword = loginDao.getUserPw(params);
        // 비밀번호가 일치하지 않을 경우
        if( !(passwordEncoder.matches(password, encodePassword)) ) {
            result.put("message", "비밀번호가 일치하지 않습니다.");
            return result;
        }

        result.put("result", 1);

        return result;
    }
}
