package com.w3wp;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ScrittoDAO {
    private static EntityManager em =  JpaUtil.getEntityManagerFactory().createEntityManager();
    private static EntityTransaction transaction = em.getTransaction();

    public static void save(Scritto scritto){
        transaction.begin();
        em.persist(scritto);
        transaction.commit();
    }
    public static void remove(Scritto scritto){
        transaction.begin();
        em.remove(scritto);
        transaction.commit();
    }
}
