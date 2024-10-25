package com.Joonggodeal.joonggodeal.SignInUp.Dao;


import com.Joonggodeal.joonggodeal.SignInUp.DTO.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.HashMap;

@Mapper
public interface MemberDao {

    int memberRegister(MemberDTO params);

    int isDuplicateId(HashMap<String, Object> params);

    int isDuplicateNickName(HashMap<String, Object> params);

    HashMap<String, Object> loadUserInfo(HashMap<String, Object> params) throws SQLException;

    HashMap<String, Object> getUserInfo(HashMap<String, Object> params) throws SQLException;

    int updateUserInfo(HashMap<String, Object> params) throws SQLException;

    int deleteAccount(HashMap<String, Object> params) throws SQLException;

    String findByID(HashMap<String, Object> params);

    int findByPW(@Param("userID") String userID, @Param("phonenumber") String phonenumber);

    int updatePassword(@Param("userID") String userID, @Param("newPassword") String newPassword);
}
