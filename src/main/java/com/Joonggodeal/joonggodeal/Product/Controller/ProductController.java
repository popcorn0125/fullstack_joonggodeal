package com.Joonggodeal.joonggodeal.Product.Controller;

import com.Joonggodeal.joonggodeal.Product.Service.ProductService;
import com.Joonggodeal.joonggodeal.ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.HashMap;

@RequestMapping("/product")
@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @PostMapping("/register")
    public ResponseEntity<ResultDto<String>> goodsRegister(@RequestBody HashMap<String, Object> params) throws SQLException {
        System.out.println("Product Controller - 실행 - goodsRegister");
        productService.goodsRegister(params);
        return ResponseEntity.ok(ResultDto.res(HttpStatus.OK, HttpStatus.OK.toString(), "Success"));
    }

    @PostMapping("/update")
    public ResponseEntity<ResultDto<String>> goodsUpdate(@RequestBody HashMap<String, Object> params) throws SQLException {
        System.out.println("Product Controller - 실행 - goodsUpdate");
        productService.goodsUpdate(params);
        return ResponseEntity.ok(ResultDto.res(HttpStatus.OK, HttpStatus.OK.toString(), "update Success"));
    }

    @PostMapping("/delete")
    public ResponseEntity<ResultDto<String>> goodsDelete(@RequestBody HashMap<String, Object> params) throws SQLException {
        System.out.println("Product Controller - 실행 - goodsDelete");
        productService.goodsDelete(params);
        return ResponseEntity.ok(ResultDto.res(HttpStatus.OK, HttpStatus.OK.toString(), "delete Success"));
    }

    @PostMapping("/getallgoods")
    public ResponseEntity<ResultDto<String>> getAllGoods(@RequestBody HashMap<String, Object> params) throws SQLException {
        System.out.println("Product Controller - 실행 - getAllGoods");
        return ResponseEntity.ok(ResultDto.res(HttpStatus.OK, HttpStatus.OK.toString(), productService.getAllGoods(params).toString()));
    }
}
