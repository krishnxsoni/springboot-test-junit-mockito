package org.jpgroups.springtest.service;

import jakarta.transaction.Transactional;
import org.jpgroups.springtest.dto.ProductRequestDto;
import org.jpgroups.springtest.dto.ProductResponseDto;
import org.jpgroups.springtest.dto.Response;
import org.jpgroups.springtest.entity.Product;
import org.jpgroups.springtest.repository.ProductRepository;
import org.jpgroups.springtest.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService
{
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public ProductResponseDto getProductById(long id)
    {
        Optional<Product> optionalProduct = productRepository.findById(id);

        Product product = null;
        ProductResponseDto responseDto = new ProductResponseDto();
        Response responseMessage = new Response();

        if(optionalProduct.isPresent())
        {
            product = optionalProduct.get();

            responseMessage.setMessage(Constants.API_RESPONSE_SUCCESS);
            responseDto.setResponse(responseMessage);

            responseDto.setProductName(product.getProductName());
            responseDto.setProductPrice(product.getProductPrice());
            responseDto.setProductQuantity(product.getProductQuantity());
        }
        else
        {
            responseMessage.setMessage(Constants.API_RESPONSE_FAILURE);
            responseDto.setResponse(responseMessage);
        }
        return responseDto;
    }

    @Transactional
    public ProductResponseDto createProduct(ProductRequestDto requestDto)
    {
        ProductResponseDto  responseDto = new ProductResponseDto();
        Response responseMessage = new Response();

        // BASIC VALIDATIONS - 1
        if(requestDto == null) {
            responseMessage.setMessage(Constants.INVALID_REQUEST);
            responseDto.setResponse(responseMessage);
            return responseDto;
        }

        // BASIC VALIDATIONS - 2
        boolean isProductExist = productRepository.existsByProductName(requestDto.getProductName());
        if(isProductExist) {
            responseMessage.setMessage(Constants.PRODUCT_ALREADY_EXIST);
            responseDto.setResponse(responseMessage);
            return responseDto;
        }

        Product newProduct = new Product();
        newProduct.setProductName(requestDto.getProductName());
        newProduct.setProductPrice(requestDto.getProductPrice());
        newProduct.setProductQuantity(requestDto.getProductQuantity());

        Product savedProduct = productRepository.save(newProduct);
        responseMessage.setMessage(Constants.PRODUCT_CREATED);

        responseDto.setResponse(responseMessage);
        responseDto.setProductName(savedProduct.getProductName());
        responseDto.setProductPrice(savedProduct.getProductPrice());
        responseDto.setProductQuantity(savedProduct.getProductQuantity());
        return responseDto;
    }

}
