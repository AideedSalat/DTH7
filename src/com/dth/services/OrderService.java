package com.dth.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.dth.models.Order_Details;

/**
 * Session Bean implementation class OrderService
 */
@Stateless
@LocalBean
public class OrderService {

    /**
     * Default constructor. 
     */
    public OrderService() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="dth")
    private EntityManager em;
    
    public void addOrder(Order_Details o)
    {
    	em.persist(o);
    }
    
    public void updateOrder(Order_Details o)
    {
    	em.merge(o);
    	em.flush();
    }
    
    
    public Order_Details getOrder(int oid)
    {
    	em.flush();
    	return em.find(Order_Details.class, oid);
    }
    
}
