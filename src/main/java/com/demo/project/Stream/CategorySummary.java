package com.demo.project.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CategorySummary{
    private long productCount;
    private BigDecimal totalPrice;
}
