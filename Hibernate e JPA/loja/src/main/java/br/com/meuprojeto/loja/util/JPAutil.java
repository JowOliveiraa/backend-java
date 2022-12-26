package br.com.meuprojeto.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAutil {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("loja_jpa");

    public static  EntityManager getEntityManger() {
        return FACTORY.createEntityManager();
    }
}
