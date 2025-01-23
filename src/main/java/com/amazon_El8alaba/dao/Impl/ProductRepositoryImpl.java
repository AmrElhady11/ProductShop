package com.amazon_El8alaba.dao.Impl;

import com.amazon_El8alaba.dao.ProductRepository;
import com.amazon_El8alaba.entity.ProductDetailsEntity;
import com.amazon_El8alaba.entity.ProductEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductRepositoryImpl implements ProductRepository {
   private EntityManager entityManager;
   @Autowired
   public ProductRepositoryImpl(EntityManager entityManager)
   {
       this.entityManager = entityManager;
   }
    @Override
    @Transactional
    public ProductEntity insert(ProductDetailsEntity productDetails) {
       ProductEntity product = new ProductEntity();
       product.setName(productDetails.getName());
       productDetails.setProductId(product);
       entityManager.persist(productDetails);
        return product;
    }

    @Override
    public ProductEntity findById(int id) {

        return entityManager.find(ProductEntity.class,id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
       ProductEntity product = findById(id);
        if (product != null) {
            entityManager.remove(product);
        }
    }

    @Override
    @Transactional
    public void update(ProductDetailsEntity productDetails) {
        System.out.println("the id :" +productDetails.getId());
        ProductEntity product = findById(productDetails.getId());
        if (product != null) {
            product.setName(productDetails.getName());
            entityManager.merge(product);
        }
        productDetails.setProductId(product);
        entityManager.merge(productDetails);


    }

    @Override
    public List<ProductEntity> findAll() {
        TypedQuery<ProductEntity> theQuery = entityManager.createQuery("from ProductEntity ",ProductEntity.class);

        return theQuery.getResultList();
    }

    @Override
    public ProductDetailsEntity findProductDetailsById(int id) {
        return entityManager.find(ProductDetailsEntity.class,id);

    }
}
