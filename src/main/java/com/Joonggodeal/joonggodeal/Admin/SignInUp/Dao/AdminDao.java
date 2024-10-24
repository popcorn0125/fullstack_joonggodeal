package com.Joonggodeal.joonggodeal.Admin.SignInUp.Dao;


import com.Joonggodeal.joonggodeal.Admin.SignInUp.DTO.AdminDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.HashMap;

/*******************
 * 날짜 : 2024.07.15
 * 이름 : 김준식
 * 내용 : 회원 DAO
 * *****************/
@Mapper
public interface AdminDao {

    /*******************
     * 날짜 : 2024.07.15
     * 이름 : 김준식
     * 내용 : 회원 등록( DB에 데이터 저장)
     * *****************/
    int memberRegister(AdminDTO params);

    /*******************
     * 날짜 : 2024.07.16
     * 이름 : 김준식
     * 내용 : 아이디 중복이 있는지 확인 ( 아이디 중복 확인 )
     * *****************/
    int isDuplicateId(HashMap<String, Object> params);

    /*******************
     * 날짜 : 2024.08.01
     * 이름 : 김준식
     * 내용 : 회원탈퇴
     * *****************/
    int deleteAccount(HashMap<String, Object> params) throws SQLException;

    /*******************
     * 날짜 : 2024.08.05
     * 이름 : 권지용
     * 내용 : 아이디 찾기
     * *****************/
    String findByID(HashMap<String, Object> params);

    int findByPW(@Param("userID") String userID, @Param("phonenumber") String phonenumber);

    int updatePassword(@Param("userID") String userID, @Param("newPassword") String newPassword);
}
