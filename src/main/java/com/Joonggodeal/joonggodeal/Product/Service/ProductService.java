package com.Joonggodeal.joonggodeal.Product.Service;

import com.Joonggodeal.joonggodeal.Product.DAO.ProductDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.sql.SQLException;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productDao;

    public void goodsRegister(HashMap<String, Object> params) throws SQLException {
        productDao.goodsRegister(params);
    }

    public void goodsUpdate(HashMap<String, Object> params) throws SQLException {
        productDao.goodsUpdate(params);
    }

    public void goodsDelete(HashMap<String, Object> params) throws SQLException {
        productDao.goodsDelete(params);
    }

    public List<HashMap<String, Object>> getAllGoods(HashMap<String, Object> params) throws SQLException {
        List<HashMap<String, Object>> result = new ArrayList<>();
        result = productDao.getAllGoods(params);
        return result;
    }

}
