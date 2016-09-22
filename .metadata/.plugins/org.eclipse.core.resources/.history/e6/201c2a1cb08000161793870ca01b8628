package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import oracle.sql.DATE;



@Entity
@Component
@Table(name="Blog")
public class Blog {
	
	
	
	@Id
	private String blogId;
	private String blogTitle;
	private String userId;
	private String blogDescription;
	private char status;
	private DATE DateTime;
	
	
	
	public String getBlogId() {
		return blogId;
	}
	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBlogDescription() {
		return blogDescription;
	}
	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public DATE getDateTime() {
		return DateTime;
	}
	public void setDateTime(DATE dateTime) {
		DateTime = dateTime;
	}
	
	
	

}
