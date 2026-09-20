package org.jpgroups.springtest.service;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PriceCalculatorTest
{
    private PriceCalculatorService priceCalculator = new PriceCalculatorService();

    @Test
    void checkDiscountedPrice()
    {
        // arrange --> Initial Input
        double price = 1000;
        double discountPercent = 20;

        // act --> Action performed
        double actualPrice = priceCalculator.calculatePrice(price,discountPercent);

        // assertion --> Expected output
        assertEquals(800.0,actualPrice);

    }

    @Test
    void checkDiscountPercent()
    {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        ()-> priceCalculator.calculatePrice(
                                1000,
                                120)
                );

        assertEquals("Discount percent must be between 0 and 100",
                exception.getMessage());
    }

    @Test
    void checkPrice()
    {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        ()-> priceCalculator.calculatePrice(
                                -10201,
                                10)
                );

        assertEquals("Price cannot be negative",
                exception.getMessage());
    }

}
