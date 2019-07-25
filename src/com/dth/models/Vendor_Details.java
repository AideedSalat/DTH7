package com.dth.models;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Vendor_Details
 *
 */
@Entity

public class Vendor_Details implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Vendor_Details() {
		super();
	}
	
	public Vendor_Details(Integer vid,String setupboxes, Integer quantity, Integer setupboxescost)
	{
		this.vid = vid;		
		this.setupboxes = setupboxes;
		this.quantity = quantity;
		this.setupboxescost= setupboxescost;
	}
	
	@Id
	@SequenceGenerator(name = "seq2", initialValue = 6000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq2")
	private int vid;
	
	
	private String setupboxes;
	
	private Integer quantity;
	
	private Integer setupboxescost;

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}
	

	public String getSetupboxes() {
		return setupboxes;
	}

	public void setSetupboxes(String setupboxes) {
		this.setupboxes = setupboxes;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getSetupboxescost() {
		return setupboxescost;
	}

	public void setSetupboxescost(Integer setupboxescost) {
		this.setupboxescost = setupboxescost;
	}

	@Override
	public String toString() {
		return "Vendor_Details [vid=" + vid + ", setupboxes=" + setupboxes
				+ ", quantity=" + quantity + ", setupboxescost="
				+ setupboxescost + "]";
	}

	
	
   
}
