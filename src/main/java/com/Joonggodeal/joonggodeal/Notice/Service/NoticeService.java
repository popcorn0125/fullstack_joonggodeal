package com.Joonggodeal.joonggodeal.Notice.Service;

import com.Joonggodeal.joonggodeal.Notice.Dao.NoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.HashMap;

@Service
public class NoticeService {

    @Autowired
    NoticeDao noticeDao;

    public List<HashMap<String, Object>> getAllBoards() {
        return noticeDao.getAllBoards();
    }
}
