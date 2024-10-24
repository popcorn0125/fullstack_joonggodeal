package com.Joonggodeal.joonggodeal.Admin.Product.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@Setter
@NoArgsConstructor
public class productDto {
    private String name;
    private String title;
    private String manufacturer;
    private int price;
    private String description;
    private String category;
    private String filename;

}
