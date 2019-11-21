package edu.mum.mail.model;

import java.sql.Date;

public class mailView {
	private int mailId;
	private Date deliveryDate;
	private String sender;
	private String deliveredBy;
	private String status;
	private String personId;
	
	public mailView() {
		
	}

	public mailView(int mailId, Date deliveryDate, String sender, String deliveredBy, String status, String personId) {

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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
}
