package com.dth.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.dth.models.FAQ;

/**
 * Session Bean implementation class FAQService
 */
@Stateless
@LocalBean
public class FAQService {

    /**
     * Default constructor. 
     */
    public FAQService() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="dth")
    private EntityManager em;
    
    public void addFAQ(FAQ f)
    {
    	em.persist(f);
    }
    
    public void updateFAQ(FAQ f)
    {
    	em.merge(f);
    	em.flush();
    }
    
    public void deleteFAQ(int fid)
    {
    	em.remove(getFAQ(fid));
    }
    
    public FAQ getFAQ(int fid)
    {
    	em.flush();
    	return em.find(FAQ.class, fid);
    }

}
