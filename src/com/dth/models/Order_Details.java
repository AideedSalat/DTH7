package com.dth.models;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Order_Details
 *
 */
@Entity
public class Order_Details implements Serializable {

	private static final long serialVersionUID = 1L;

	public Order_Details() {
		super();
	}

	@Id
	@SequenceGenerator(name = "seq6", initialValue = 5000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq6")
	private int oid;

	private Integer totalcost;	

	private Integer CustomerID;
	
	private Integer vendorID;
	
	private Integer PackageID;

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public Integer getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(Integer totalcost) {
		this.totalcost = totalcost;
	}

	public Integer getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(Integer customerID) {
		CustomerID = customerID;
	}

	public Integer getVendorID() {
		return vendorID;
	}

	public void setVendorID(Integer vendorID) {
		this.vendorID = vendorID;
	}

	public Integer getPackageID() {
		return PackageID;
	}

	public void setPackageID(Integer packageID) {
		PackageID = packageID;
	}

	@Override
	public String toString() {
		return "Order_Details [oid=" + oid + ", totalcost=" + totalcost
				+ ", CustomerID=" + CustomerID + ", vendorID=" + vendorID
				+ ", PackageID=" + PackageID + "]";
	}
	
}
