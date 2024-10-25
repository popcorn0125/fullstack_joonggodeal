package com.Joonggodeal.joonggodeal.SignInUp.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

@Mapper
public interface LoginDao {

    int userIdCheck(String userId);


    String getUserPw(HashMap<String, Object> params);


    int guestLogin(@Param("guestId") String uuid);

}
