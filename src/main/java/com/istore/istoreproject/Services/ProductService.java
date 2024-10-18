package com.istore.istoreproject.Services;

import java.util.List;

import com.istore.istoreproject.Requests.ProductRequest;
import com.istore.istoreproject.models.Product;

public interface ProductService {

    Product saveProduct(ProductRequest productRequest);

    Product updateProduct(ProductRequest product, long id);

    Product getById(long id);

    List<Product> findAll();

    List<Product> getByQuestion(long id);

    void deleteProduct(long id);
}
