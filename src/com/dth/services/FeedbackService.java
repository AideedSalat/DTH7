package com.dth.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.dth.models.Feedback;

/**
 * Session Bean implementation class FeedbackService
 */
@Stateless
@LocalBean
public class FeedbackService {

    /**
     * Default constructor. 
     */
    public FeedbackService() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="dth")
    private EntityManager em;
    
    public void addFeedback(Feedback f){
    	em.persist(f);
    }
    
    public void deleteFeedback(int fid)
    {
    	em.remove(getFeedback(fid));
    }
    
    public Feedback getFeedback(int fid)
    {
    	em.flush();
    	return em.find(Feedback.class, fid);
    }


}
