package org.jpgroups.springtest.repository;

import org.jpgroups.springtest.entity.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>
{
    boolean existsByProductName(String productName);

}
