package com.osmi.store.app.products.dto.response;

import lombok.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private String brand;
    private Long categoryId;
    private BigDecimal basePrice;
    private BigDecimal baseDiscountPercentage;
}