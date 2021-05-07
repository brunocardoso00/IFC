/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author vilso
 * @param <T>
 */
public class DAOGeneric<T extends Serializable> {

    public boolean create(T entity) {

        EntityManager connectionDb = openConnection();
        try {
            connectionDb.getTransaction().begin();
            connectionDb.persist(entity);
            connectionDb.getTransaction().commit();
        } catch (Exception exception) {

            System.out.println(MessageFormat.format("Entity: {0} \n Error: {1} ", entity.toString(), exception.getMessage()));
            connectionDb.getTransaction().rollback();
            return false;

        } finally {
            connectionDb.close();
        }
        return true;
    }

    private EntityManager openConnection() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ApplicationPU");
        return entityManagerFactory.createEntityManager();
    }

}
