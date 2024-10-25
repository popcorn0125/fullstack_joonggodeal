package com.Joonggodeal.joonggodeal.Admin.Product.DAO;

import com.Joonggodeal.joonggodeal.Admin.Product.DTO.productDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface AdminProductDao {
    void goodsRegister(productDto productDto);
    void goodsUpdate(productDto productDto);
    void goodsDelete(HashMap<String, Object> params);

    HashMap<String, Object> getOneGoods(HashMap<String, Object> params);
    List<HashMap<String, Object>> getAllGoods(HashMap<String, Object> params);
    List<String> getCategory();


}
