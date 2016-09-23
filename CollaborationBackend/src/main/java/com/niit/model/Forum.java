package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Forum {
	
	@Id
	private String forumId;
	private String userId;
	private String forumTitle;
	private String forumDescription;
	private long noOfPosts;
	private char status;
	private Date DateTime;
	
	public String getForumId() {
		return forumId;
	}
	public void setForumId(String forumId) {
		this.forumId = forumId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getForumTitle() {
		return forumTitle;
	}
	public void setForumTitle(String forumTitle) {
		this.forumTitle = forumTitle;
	}
	public String getForumDescription() {
		return forumDescription;
	}
	public void setForumDescription(String forumDescription) {
		this.forumDescription = forumDescription;
	}
	public long getNoOfPosts() {
		return noOfPosts;
	}
	public void setNoOfPosts(long noOfPosts) {
		this.noOfPosts = noOfPosts;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public Date getDateTime() {
		return DateTime;
	}
	public void setDateTime(Date dateTime) {
		DateTime = dateTime;
	}
	
	
}
