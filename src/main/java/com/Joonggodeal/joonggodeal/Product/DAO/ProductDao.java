package com.Joonggodeal.joonggodeal.Product.DAO;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.HashMap;

@Mapper
public interface ProductDao {
    List<HashMap<String, Object>> getCategory();
    List<HashMap<String , Object>> getCategoryGoods(HashMap<String, Object> params);
    HashMap<String, Object> getOneGoods(HashMap<String, Object> params);
    void submitBidPrice(HashMap<String, Object> params);
}
