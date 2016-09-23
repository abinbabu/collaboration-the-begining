package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class JobOpportunity {
	
	@Id
	private String jobOpportunityId;
	private String content;
	private Date DateTime;
	
	public String getJobOpportunityId() {
		return jobOpportunityId;
	}
	public void setJobOpportunityId(String jobOpportunityId) {
		this.jobOpportunityId = jobOpportunityId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDateTime() {
		return DateTime;
	}
	public void setDateTime(Date dateTime) {
		DateTime = dateTime;
	}
	

}
