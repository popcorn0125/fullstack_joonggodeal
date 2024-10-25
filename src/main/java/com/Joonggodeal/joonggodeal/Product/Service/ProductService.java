package com.Joonggodeal.joonggodeal.Product.Service;

import com.Joonggodeal.joonggodeal.Product.DAO.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.HashMap;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

    public List<HashMap<String, Object>> getCategory() {
        return productDao.getCategory();
    }

    public List<HashMap<String, Object>> getCategoryGoods(HashMap<String, Object> params) {
        return productDao.getCategoryGoods(params);
    }

    public HashMap<String , Object> getOneGoods(HashMap<String, Object> params) {
        return  productDao.getOneGoods(params);
    }

    public void submitBidPrice(HashMap<String, Object> params) {
        productDao.submitBidPrice(params);
    }

}
