package com.azzouz.productservice.repository;/*
 * @created 08/01/2023 - 08:41
 * @project product-service
 * @author Azzouz
 */

import com.azzouz.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
