package com.w3wp;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PrestitoDao {
    private static EntityManager em =  JpaUtil.getEntityManagerFactory().createEntityManager();
    private static EntityTransaction transaction = em.getTransaction();

    public static void save(Prestito prestito){
        try{
        transaction.begin();
        em.persist(prestito);
        transaction.commit();
        } finally {
        em.close();
        }
    }
}
