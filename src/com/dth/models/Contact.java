package com.dth.models;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Contact
 *
 */
@Entity

public class Contact implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Contact() {
		super();
	}
	
	@Id
	@SequenceGenerator(name = "seq4", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq4")
	private Integer ContactId;
	
	private String Email;
	
	private String Message;

	public Integer getContactId() {
		return ContactId;
	}

	public void setContactId(Integer contactId) {
		ContactId = contactId;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}


	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	@Override
	public String toString() {
		return "Contact [ContactId=" + ContactId + ", Email=" + Email
				+ ", Message=" + Message + "]";
	}

   
}
