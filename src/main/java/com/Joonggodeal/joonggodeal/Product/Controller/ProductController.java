package com.Joonggodeal.joonggodeal.Product.Controller;

import com.Joonggodeal.joonggodeal.Product.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/productcategory")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/getcategory")
    public ResponseEntity<?> getCategory() {
        System.out.println("ProductController - 실행 - getCategory");
        return ResponseEntity.ok(productService.getCategory());
    }

    @PostMapping("/getcategorygoods")
    public ResponseEntity<?> getCategoryGoods(@RequestBody HashMap<String, Object> params) {
        System.out.println("ProductController - 실행 - getCategoryGoods");
        return ResponseEntity.ok(productService.getCategoryGoods(params));
    }

    @PostMapping("/getonegoods")
    public ResponseEntity<?> getOneGoods(@RequestBody HashMap<String, Object> params){
        System.out.println("ProductController - 실행 - getOneGoods");
        return ResponseEntity.ok(productService.getOneGoods(params));
    }

    @PostMapping("/submitprice")
    public ResponseEntity<?> submitBidPrice(@RequestBody HashMap<String, Object> params) {
        System.out.println("ProductController - 실행 - submitBidPrice");
        productService.submitBidPrice(params);
        return ResponseEntity.ok(200);
    }

}
