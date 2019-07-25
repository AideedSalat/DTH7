package com.dth.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.dth.models.Contact;

/**
 * Session Bean implementation class ContactService
 */
@Stateless
@LocalBean
public class ContactService {

    /**
     * Default constructor. 
     */
    public ContactService() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="dth")
    private EntityManager em;
    
    public void addContact(Contact c){
    	em.persist(c);
    
    }
}
