package com.dth.models;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Package_Details
 *
 */
@NamedQuery(name = "PackageDisplay.findById", query="SELECT p FROM Package_Details p WHERE p.pid = :pid")
@Entity

public class Package_Details implements Serializable {

		
	private static final long serialVersionUID = 1L;

	public Package_Details() {
		super();
	}
	
	public Package_Details(int pid, String name, PackageType packagetype, int cost)
	{
		this.pid = pid;
		this.name = name;
		this.packagetype = packagetype;
		this.cost = cost;
	}
	
	@Id
	@SequenceGenerator(name = "seq1", initialValue = 2000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
	private int pid;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private PackageType packagetype;
	
	private Integer cost;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PackageType getPackagetype() {
		return packagetype;
	}

	public void setPackagetype(PackageType packagetype) {
		this.packagetype = packagetype;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Package_Details [pid=" + pid + ", name=" + name
				+ ", packagetype=" + packagetype + ", cost=" + cost + "]";
	}
   
}
