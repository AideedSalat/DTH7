package com.dth.models;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Customer_Details
 *
 */
@NamedQuery(name = "Customer_Details.findById", query = "SELECT c FROM Customer_Details c WHERE c.Customerid = :Customerid")
@Entity
public class Customer_Details implements Serializable {

	private static final long serialVersionUID = 1L;

	public Customer_Details() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Customerid;

	private String name;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	private String Address;

	private String email;

	private String password;

	private Long contact;

	private Integer payments;

	@Column(unique = true, nullable = false)
	private Long cardnumber;
	
	private String Role;

	public Integer getCustomerid() {
		return Customerid;
	}

	public void setCustomerid(Integer customerid) {
		Customerid = customerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public Integer getPayments() {
		return payments;
	}

	public void setPayments(Integer payments) {
		this.payments = payments;
	}

	public Long getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(Long cardnumber) {
		this.cardnumber = cardnumber;
	}
	
	

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	@Override
	public String toString() {
		return "Customer_Details [Customerid=" + Customerid + ", name=" + name
				+ ", gender=" + gender + ", Address=" + Address + ", email="
				+ email + ", password=" + password + ", contact=" + contact
				+ ", payments=" + payments + ", cardnumber=" + cardnumber
				+ ", Role=" + Role + "]";
	}

	

}
