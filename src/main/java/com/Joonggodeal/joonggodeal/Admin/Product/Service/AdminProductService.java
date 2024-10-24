package com.Joonggodeal.joonggodeal.Admin.Product.Service;

import com.Joonggodeal.joonggodeal.Admin.Product.DAO.AdminProductDao;
import com.Joonggodeal.joonggodeal.Admin.Product.DTO.fileVO;
import com.Joonggodeal.joonggodeal.Admin.Product.DTO.productDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.sql.SQLException;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AdminProductService {

    private final AdminProductDao adminProductDao;

//    public void goodsRegister(HashMap<String, Object> params) throws SQLException {
//        adminProductDao.goodsRegister(params);
//    }

    public void goodsUpdate(HashMap<String, Object> params) throws SQLException {
        adminProductDao.goodsUpdate(params);
    }

    public void goodsDelete(HashMap<String, Object> params) throws SQLException {
        adminProductDao.goodsDelete(params);
    }

    public List<HashMap<String, Object>> getProductList(HashMap<String, Object> params){
        List<HashMap<String, Object>> result = new ArrayList<>();
        result = adminProductDao.getAllGoods(params);
        return result;
    }

    public List<String> getCategory() {
        return adminProductDao.getCategory();
    }

    public void goodsRegister(productDto productDto) {
        adminProductDao.goodsRegister(productDto);
    }

}
