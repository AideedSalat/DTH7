package com.dth.models;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: FAQ
 *
 */
@Entity
public class FAQ implements Serializable {

	private static final long serialVersionUID = 1L;

	public FAQ() {
		super();
	}
	
	public FAQ(int fid, String question, String answer)
	{
		this.fid = fid;
		this.question = question;
		this.answer = answer;
	}

	@Id
	@SequenceGenerator(name = "seq5", initialValue = 3000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq5")
	private int fid;

	private String question;

	private String answer;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "FAQ [fid=" + fid + ", question=" + question + ", answer="
				+ answer + "]";
	}

}
