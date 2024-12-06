package com.demo.project.Stream;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "product")
public class Product {
    private Long id;
    private String name;
    private String category;
    private BigDecimal price;
    private Double rating;
    private LocalDate releaseDate;
}
