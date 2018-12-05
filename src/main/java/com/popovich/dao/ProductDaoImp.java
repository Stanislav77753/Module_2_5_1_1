package com.popovich.dao;

import com.popovich.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProductDaoImp implements ProductDao {

    private static final Logger logger = LoggerFactory.getLogger(ProductDaoImp.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(product);
        logger.info("Product successfully saved. Product details: " + product);
    }

    @Override
    public void updateProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
        logger.info("Product successfully update. Product details: " + product);
    }

    @Override
    public void removeProduct(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Product product = (Product) session.load(Product.class, id);
        if(product!=null){
            session.delete(product);
        }
        logger.info("Product successfully removed. Product details: " + product);
    }

    @Override
    public Product getProductById(Long id) {
        Session session =this.sessionFactory.getCurrentSession();
        Product product = (Product) session.load(Product.class, id);
        logger.info("Product successfully loaded. Product details: " + product);
        return product;
    }

    @Override
    public List<Product> getProducts() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Product> products = session.createQuery("from Product").list();
        for(Product product : products){
            logger.info("Product list: " + product);
        }

        return products;
    }
}
