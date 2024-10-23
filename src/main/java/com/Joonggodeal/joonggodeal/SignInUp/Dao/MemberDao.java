package com.Joonggodeal.joonggodeal.SignInUp.Dao;


import com.Joonggodeal.joonggodeal.SignInUp.DTO.MemberDTO;
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
public interface MemberDao {

    /*******************
     * 날짜 : 2024.07.15
     * 이름 : 김준식
     * 내용 : 회원 등록( DB에 데이터 저장)
     * *****************/
    int memberRegister(MemberDTO params);

    /*******************
     * 날짜 : 2024.07.16
     * 이름 : 김준식
     * 내용 : 아이디 중복이 있는지 확인 ( 아이디 중복 확인 )
     * *****************/
    int isDuplicateId(HashMap<String, Object> params);

    /*******************
     * 날짜 : 2024.07.16
     * 이름 : 김준식
     * 내용 : 닉네임 중복이 있는지 확인 ( 닉네임 중복 확인 )
     * *****************/
    int isDuplicateNickName(HashMap<String, Object> params);

    /*******************
     * 날짜 : 2024.07.29
     * 이름 : 김준식
     * 내용 : 마이페이지에서 회원 정보 불러오기
     * *****************/
    HashMap<String, Object> loadUserInfo(HashMap<String, Object> params) throws SQLException;

    /*******************
     * 날짜 : 2024.08.01
     * 이름 : 김준식
     * 내용 : 정보수정페이지에 필요한 회원정보 불러오기
     * *****************/
    HashMap<String, Object> getUserInfo(HashMap<String, Object> params) throws SQLException;

    /*******************
     * 날짜 : 2024.08.02
     * 이름 : 김준식
     * 내용 : 정보수정에서 회원정보 수정하기
     * *****************/
    int updateUserInfo(HashMap<String, Object> params) throws SQLException;

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
