/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.poznan.put.cie.coffee;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author karol
 */

public class SuppliersDao {
    
private final EntityManager entityManager;

    public SuppliersDao() {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("pl.poznan.put.cie_coffee_jar_0.1PU");
        
        entityManager = factory.createEntityManager();
    }

    public List<Suppliers> GetAllSuppliers() {
        return entityManager
                .createNamedQuery("Suppliers.findAll", Suppliers.class)
                .getResultList();
    }

    public Suppliers GetSupplier(String name) {
        try {            
            Suppliers ent = (Suppliers) entityManager
                    .createNamedQuery("Suppliers.findBySupName", Suppliers.class)
                    .setParameter("supName", name)
                    .getSingleResult();        
            return ent;
            
        } catch (Exception e) {
            return null;
        }
    }

    public void AddSupplier(Suppliers suppliers) {
        entityManager.getTransaction().begin();

        try {
            entityManager.merge(suppliers);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void DeleteSupplier(int id) {
        entityManager.getTransaction().begin();

        try {             
            entityManager.remove(entityManager.find(Suppliers.class, id));         
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }
}
