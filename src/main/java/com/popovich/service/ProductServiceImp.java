package com.popovich.service;

import com.popovich.dao.ProductDao;
import com.popovich.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    @Transactional
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    @Override
    @Transactional
    public void removeProduct(Long id) {
        productDao.removeProduct(id);
    }

    @Override
    @Transactional
    public Product getProductById(Long id) {
        return productDao.getProductById(id);
    }

    @Override
    @Transactional
    public List<Product> getProducts() {
        return productDao.getProducts();
    }
}
