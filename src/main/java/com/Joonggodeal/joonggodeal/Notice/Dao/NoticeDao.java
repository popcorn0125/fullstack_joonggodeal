package com.Joonggodeal.joonggodeal.Notice.Dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.*;
import java.util.HashMap;

@Mapper
public interface NoticeDao {
    List<HashMap<String, Object>> getAllBoards();
}
