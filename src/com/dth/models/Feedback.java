package com.dth.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Feedback
 *
 */
@Entity

public class Feedback implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Feedback() {
		super();
	}
   
	@Id
	@SequenceGenerator(name = "seq3", initialValue = 7000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq3")
	private Integer F_Id;
	
	private String Email;
	
	private String Subject;
	
	private String Message;

	public Integer getF_Id() {
		return F_Id;
	}

	public void setF_Id(Integer f_Id) {
		F_Id = f_Id;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	@Override
	public String toString() {
		return "Feedback [F_Id=" + F_Id + ", Email=" + Email + ", Subject="
				+ Subject + ", Message=" + Message + "]";
	}
	
	
}
