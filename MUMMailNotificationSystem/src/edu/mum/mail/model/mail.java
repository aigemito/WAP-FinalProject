package edu.mum.mail.model;

import java.sql.Date;

public class mail {
	private int mailId;
	private Date deliveryDate;
	private String sender;
	private String deliveredBy;
	private int status;
	private int personId;
	
	public mail() {
		
	}

	public mail(int mailId, Date deliveryDate, String sender, String deliveredBy, int status, int personId) {

		this.mailId = mailId;
		this.deliveryDate = deliveryDate;
		this.sender = sender;
		this.deliveredBy = deliveredBy;
		this.status = status;
		this.personId=personId;
	}
	public int getMailId() {
		return mailId;
	}
	public void setMailId(int mailId) {
		this.mailId = mailId;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getDeliveredBy() {
		return deliveredBy;
	}
	public void setDeliveredBy(String deliveredBy) {
		this.deliveredBy = deliveredBy;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
}
