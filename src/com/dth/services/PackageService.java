package com.dth.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.dth.models.Package_Details;

/**
 * Session Bean implementation class PackageService
 */
@Stateless
@LocalBean
public class PackageService {

    /**
     * Default constructor. 
     */
    public PackageService() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="dth")
    
    private EntityManager em;
    
    public void addPackage(Package_Details p)
    {
    	em.persist(p);
    }
    
    public void updatePackage(Package_Details p)
    {
    	em.merge(p);
    	em.flush();
    }
    
    public void deletePackage(int pid)
    {
    	em.remove(getPackage(pid));
    }
    
    public Package_Details getPackage(int pid)
    {
    	em.flush();
    	return em.find(Package_Details.class, pid);
    }
    
    public List<Package_Details> getPackageDisplay() {
		TypedQuery<Package_Details> query = em.createQuery("SELECT p FROM Package_Details p",
				Package_Details.class);
		List<Package_Details> results = query.getResultList();
		return results;
	}
    	
}
