package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class ForumPost {
	
	@Id
	private String forumPostId;
	private String forumId;
	private String userId;
	private String forumPostContent;
	private Date DateTime;
	
	
	public String getForumPostId() {
		return forumPostId;
	}
	public void setForumPostId(String forumPostId) {
		this.forumPostId = forumPostId;
	}
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
	public String getForumPostContent() {
		return forumPostContent;
	}
	public void setForumPostContent(String forumPostContent) {
		this.forumPostContent = forumPostContent;
	}
	public Date getDateTime() {
		return DateTime;
	}
	public void setDateTime(Date dateTime) {
		DateTime = dateTime;
	}
	

}
