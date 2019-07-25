package com.dth.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.dth.models.Customer_Details;

/**
 * Session Bean implementation class CustomerService
 */
@Stateless
@LocalBean
public class CustomerService {

    /**
     * Default constructor. 
     */
    public CustomerService() {
        
    }
    
    @PersistenceContext(unitName="dth")
    private EntityManager em;
    
    public void addCustomer(Customer_Details c)
    {
    	em.persist(c);
    }
    public void updateCustomer(Customer_Details c)
    {
    	em.merge(c);
    	em.flush();
    }
    public void deleteUser(int Uid)
    {
    	em.remove(getCustomer(Uid));
    }
    public Customer_Details getCustomer(int Uid)
    {
    	em.flush();
    	return em.find(Customer_Details.class, Uid);
    }
    
    

}
