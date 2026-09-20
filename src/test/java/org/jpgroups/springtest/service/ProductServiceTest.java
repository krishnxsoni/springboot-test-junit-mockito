package org.jpgroups.springtest.service;

import org.jpgroups.springtest.entity.Product;
import org.jpgroups.springtest.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest
{
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductService productService = new ProductService(productRepository);

    @Test
    void shouldReturnProduct()
    {
        Product product = new Product(
                1L,"Laptop",48999.0,21);

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        String actualProductName = productService.getProductById(1L).getProductName();
        assertEquals("Laptop",actualProductName);

        verify(productRepository).findById(1L); // to verify if this method has been called or not!!!
    }
}
