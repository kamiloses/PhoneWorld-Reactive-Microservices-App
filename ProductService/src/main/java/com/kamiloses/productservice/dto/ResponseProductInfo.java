package com.kamiloses.productservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseProductInfo {

    private String productName;
    private Integer quantity;
    private Double pricePerUnit;

}
