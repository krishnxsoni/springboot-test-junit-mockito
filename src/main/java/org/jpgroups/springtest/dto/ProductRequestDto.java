package org.jpgroups.springtest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto
{
    private String productName;
    private Double productPrice;
    private Integer productQuantity;
}
