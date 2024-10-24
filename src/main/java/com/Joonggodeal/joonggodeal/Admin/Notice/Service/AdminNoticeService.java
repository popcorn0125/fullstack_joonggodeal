package com.Joonggodeal.joonggodeal.Admin.Notice.Service;

import com.Joonggodeal.joonggodeal.Admin.Notice.DAO.AdminNoticeDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminNoticeService {
    AdminNoticeDao adminNoticeDao;

    public int register(HashMap<String, Object> params) {
        return adminNoticeDao.register(params);
    }

    public List<HashMap<String,Object>> getNoticeAll(HashMap<String, Object> params) {
        return adminNoticeDao.getNoticeAll(params);
    }

    public void noticeDelete(HashMap<String, Object> params){
        adminNoticeDao.noticeDelete(params);
    }

    public HashMap<String,Object> getOneNotice(HashMap<String, Object> params) {
        return adminNoticeDao.getOneNotice(params);
    }
}
