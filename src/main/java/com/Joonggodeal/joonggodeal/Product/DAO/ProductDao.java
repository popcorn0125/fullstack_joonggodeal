package com.Joonggodeal.joonggodeal.Product.DAO;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface ProductDao {
    void goodsRegister(HashMap<String, Object> params);
    void goodsUpdate(HashMap<String, Object> params);
    void goodsDelete(HashMap<String, Object> params);
    List<HashMap<String, Object>> getAllGoods(HashMap<String, Object> params);
}
