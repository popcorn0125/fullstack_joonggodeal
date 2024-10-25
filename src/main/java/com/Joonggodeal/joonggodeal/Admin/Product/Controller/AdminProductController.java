package com.Joonggodeal.joonggodeal.Admin.Product.Controller;

import com.Joonggodeal.joonggodeal.Admin.Product.DTO.fileVO;
import com.Joonggodeal.joonggodeal.Admin.Product.DTO.productDto;
import com.Joonggodeal.joonggodeal.Admin.Product.Service.AdminProductService;
import com.Joonggodeal.joonggodeal.ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RequestMapping("/adminproduct")
@RequiredArgsConstructor
@RestController
public class AdminProductController {

    private final AdminProductService adminProductService;

//    @PostMapping("/update")
//    public ResponseEntity<ResultDto<String>> goodsUpdate(@RequestBody HashMap<String, Object> params) throws SQLException {
//        System.out.println("Product Controller - 실행 - goodsUpdate");
//        adminProductService.goodsUpdate(params);
//        return ResponseEntity.ok(ResultDto.res(HttpStatus.OK, HttpStatus.OK.toString(), "update Success"));
//    }

//    @PostMapping("/delete")
//    public ResponseEntity<ResultDto<String>> goodsDelete(@RequestBody HashMap<String, Object> params) throws SQLException {
//        System.out.println("Product Controller - 실행 - goodsDelete");
//        adminProductService.goodsDelete(params);
//        return ResponseEntity.ok(ResultDto.res(HttpStatus.OK, HttpStatus.OK.toString(), "delete Success"));
//    }


    @PostMapping("/getcategory")
    public ResponseEntity<List<String>> getCategory() {
        System.out.println("Admin Product Controller - 실행 - getCategory");
        return ResponseEntity.ok(adminProductService.getCategory());
    }

    @PostMapping("/register")
    public ResponseEntity<Integer> productRegister(
        @RequestParam("name") String name,
        @RequestParam("title") String title,
        @RequestParam("manufacturer") String manufacturer,
        @RequestParam("price") int price,
        @RequestParam("description") String description,
        @RequestParam("category") String category,
        @RequestParam("id") String id,
        @RequestParam("image") MultipartFile  image) throws Exception  {

        productDto productDto = new productDto();
        productDto.setName(name);
        productDto.setTitle(title);
        productDto.setManufacturer(manufacturer);
        productDto.setPrice(price);
        productDto.setDescription(description);
        productDto.setCategory(category);
        productDto.setId(id);

        String fileName = null;

        if (!image.isEmpty()) { //file객체가 비어있지 않다면

            String originalFileName = image.getOriginalFilename(); //파일의 실제 이름
            String ext = originalFileName.substring(originalFileName.lastIndexOf(".") + 1); //파일의 확장자
            UUID uuid = UUID.randomUUID(); //파일의 새로운 닉네임 같은거....
            fileName = uuid.toString() + "." + ext; // UUID + 확장자 형태로 파일명 생성
            //DB에 담아주는게 좋으나 나는 간단하게 작성을 위하여 파일명만 지정
            image.transferTo(new File("d:\\upload\\"+fileName)); //new File 객체를 통해 file객체를 만들고
            //"c:\\upload\\"지정해준 경로에 파일새로만들기
            productDto.setFilename(fileName);
            adminProductService.goodsRegister(productDto); // 담아준 vo를 비지니스로직에 태워보냄
        }



        return ResponseEntity.ok(200);
    }

    @PostMapping("/update")
    public ResponseEntity<Integer> productUpdate(
            @RequestParam("name") String name,
            @RequestParam("title") String title,
            @RequestParam("manufacturer") String manufacturer,
            @RequestParam("price") int price,
            @RequestParam("description") String description,
            @RequestParam("category") String category,
            @RequestParam("idx") int idx,
            @RequestParam("image") MultipartFile  image) throws Exception  {

        productDto productDto = new productDto();
        productDto.setName(name);
        productDto.setTitle(title);
        productDto.setManufacturer(manufacturer);
        productDto.setPrice(price);
        productDto.setDescription(description);
        productDto.setCategory(category);
        productDto.setIdx(idx);

        String fileName = null;

        if (!image.isEmpty()) { //file객체가 비어있지 않다면

            String originalFileName = image.getOriginalFilename(); //파일의 실제 이름
            String ext = originalFileName.substring(originalFileName.lastIndexOf(".") + 1); //파일의 확장자
            UUID uuid = UUID.randomUUID(); //파일의 새로운 닉네임 같은거....
            fileName = uuid.toString() + "." + ext; // UUID + 확장자 형태로 파일명 생성
            //DB에 담아주는게 좋으나 나는 간단하게 작성을 위하여 파일명만 지정
            image.transferTo(new File("d:\\upload\\"+fileName)); //new File 객체를 통해 file객체를 만들고
            //"c:\\upload\\"지정해준 경로에 파일새로만들기
            productDto.setFilename(fileName);
            adminProductService.goodsUpdate(productDto); // 담아준 vo를 비지니스로직에 태워보냄
        }



        return ResponseEntity.ok(200);
    }

    @PostMapping("/getproductlist")
    public ResponseEntity<?> getProductList(@RequestBody HashMap<String, Object> params) {
        System.out.println("AdminProductController - getproductList 실행");
        return ResponseEntity.ok(adminProductService.getProductList(params));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody HashMap<String, Object> params) throws SQLException {
        System.out.println("AdminProductController - delete 실행");
        adminProductService.goodsDelete(params);
        return ResponseEntity.ok(200);
    }

    @PostMapping("/getonegoods")
    public ResponseEntity<?> getOneGoods(@RequestBody HashMap<String, Object> params) {
        System.out.println("parmas : " + params.get("idx"));
        return ResponseEntity.ok(adminProductService.getOneGoods(params));
    }
}
