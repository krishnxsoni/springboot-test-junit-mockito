package org.jpgroups.springtest.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto
{
    private Response response;
    private String productName;
    private Double productPrice;
    private Integer productQuantity;

}
