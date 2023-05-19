package com.w3wp;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UtenteDAO {
    private static EntityManager em =  JpaUtil.getEntityManagerFactory().createEntityManager();
    private static EntityTransaction transaction = em.getTransaction();

    public static void save(Utente utente){
        try{
        transaction.begin();
        em.persist(utente);
        transaction.commit();
        } finally {
        em.close();
        }
    }
}
