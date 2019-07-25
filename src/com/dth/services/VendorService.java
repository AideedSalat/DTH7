package com.dth.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.dth.models.Vendor_Details;

/**
 * Session Bean implementation class VendorService
 */
@Stateless
@LocalBean
public class VendorService {

    /**
     * Default constructor. 
     */
    public VendorService() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="dth")
    private EntityManager em;
    
    public void addVendor(Vendor_Details v)
    {
    	em.persist(v);
    }
    
    public void updateVendor(Vendor_Details v)
    {
    	em.merge(v);
    	em.flush();
    }
    
    public void deleteVendor(int vid)
    {
    	em.remove(getVendor(vid));
    }
    
    public Vendor_Details getVendor(int vid)
    {
    	em.flush();
    	return em.find(Vendor_Details.class, vid);
    }

}
