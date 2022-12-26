package br.com.meuprojeto.loja.dao;

import br.com.meuprojeto.loja.model.Category;
import br.com.meuprojeto.loja.model.Product;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private EntityManager entityManager;

    public ProductDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public  void register(Product product) {
        this.entityManager.persist(product);
    }

    public void update (Product product) {
        this.entityManager.merge(product);
    }

    public void remove(Product product) {
        product = entityManager.merge(product);
        this.entityManager.remove(product);
    }

    public Product find(Long id) {
        return entityManager.find(Product.class, id);
    }

    public List<Product> list() {
        String jpql = "SELECT p from Product p";
        return entityManager.createQuery(jpql, Product.class).getResultList();
    }

    public List<Product> searchByName(String name) {
        String jpql = "SELECT p FROM Product p WHERE p.name = :name";
        return entityManager.createQuery(jpql, Product.class).setParameter("name", name).getResultList();
    }
}
