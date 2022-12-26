package br.com.meuprojeto.loja.dao;

import br.com.meuprojeto.loja.model.Category;
import br.com.meuprojeto.loja.model.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryDAO {

    private EntityManager entityManager;

    public CategoryDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void register (Category category) {
        this.entityManager.persist(category);
    }

    public void update(Category category) {
        this.entityManager.merge(category);
    }

    public void remove(Category category) {
        category = entityManager.merge(category);
        this.entityManager.remove(category);
    }

    public Category find(Long id) {
        return entityManager.find(Category.class, id);
    }

    public List<Category> list() {
        String jpql = "SELECT c FROM CATEGORY c";
        return entityManager.createQuery( jpql, Category.class).getResultList();
    }
}
