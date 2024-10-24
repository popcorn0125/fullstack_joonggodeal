package com.Joonggodeal.joonggodeal.Admin.Notice.DAO;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AdminNoticeDao {
    int register(HashMap<String, Object> params);
    List<HashMap<String, Object>> getNoticeAll(HashMap<String, Object> params);
    void noticeDelete(HashMap<String, Object> params);
    HashMap<String, Object> getOneNotice(HashMap<String, Object> params);
}
