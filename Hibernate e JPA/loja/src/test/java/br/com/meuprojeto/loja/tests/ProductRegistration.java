package br.com.meuprojeto.loja.tests;

import br.com.meuprojeto.loja.dao.CategoryDAO;
import br.com.meuprojeto.loja.dao.ProductDAO;
import br.com.meuprojeto.loja.model.Category;
import br.com.meuprojeto.loja.model.Product;
import br.com.meuprojeto.loja.util.JPAutil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductRegistration {

    public static void main(String[] args) {

        registerProduct();
        EntityManager entityManager =JPAutil.getEntityManger();
        ProductDAO productDAO = new ProductDAO(entityManager);

        Product p = productDAO.find(2L);
        System.out.println(p.getName() + " " + p.getPrice());
        System.out.println("**********************************************");

        List<Product> products = productDAO.list();
        products.forEach(product -> System.out.println(product.getName() +" "+product.getId()));

        System.out.println("**********************************************");

        List<Product> products2 = productDAO.searchByName("Samsung");
        products2.forEach(product -> System.out.println(product.getName() +" "+product.getId()));
    }

    private static void registerProduct() {
        Category celulares = new Category("celulares");

        Product celular = new Product("Samsung", "Celular Coreano", new BigDecimal("800"), celulares);

        EntityManager entityManager = JPAutil.getEntityManger();
        ProductDAO productDAO = new ProductDAO(entityManager);
        CategoryDAO categoryDAO = new CategoryDAO(entityManager);

        entityManager.getTransaction().begin();
        categoryDAO.register(celulares);
        productDAO.register(celular);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
