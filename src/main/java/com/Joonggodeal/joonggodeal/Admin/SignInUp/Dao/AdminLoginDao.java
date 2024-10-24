package com.Joonggodeal.joonggodeal.Admin.SignInUp.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

/*******************
 * 날짜 : 2024.07.10
 * 이름 : 김준식
 * 내용 : login Dao
 * *****************/
@Mapper
public interface AdminLoginDao {

    /*******************
     * 날짜 : 2024.07.10
     * 이름 : 김준식
     * 내용 : 아이디 확인
     * *****************/
    int userIdCheck(String userId);

    /*******************
     * 날짜 : 2024.07.10
     * 이름 : 김준식
     * 내용 : 비밀번호 확인
     * *****************/
    String getUserPw(HashMap<String, Object> params);

    /*******************
     * 날짜 : 2024.07.28
     * 이름 : 김준식
     * 내용 : 게스트 식별값 저장
     * *****************/
    int guestLogin(@Param("guestId") String uuid);

}
