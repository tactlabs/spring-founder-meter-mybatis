package org.tact.base.mybatis.domain;

import java.io.Serializable;
import java.util.Date;

public class FounderMeter implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String linkedin_link;
	
	private Integer auth_meter;

	private String admin_comment;
	
	private Date added_date;
	
	private Date updated_date;

	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	

	public String getLinkedin_link() {
		return linkedin_link;
	}
	

	public void setLinkedin_link(String linkedin_link) {
		this.linkedin_link = linkedin_link;
	}
	

	public Integer getAuth_meter() {
		return auth_meter;
	}
	

	public void setAuth_meter(Integer auth_meter) {
		this.auth_meter = auth_meter;
	}
	

	public String getAdmin_comment() {
		return admin_comment;
	}
	

	public void setAdmin_comment(String admin_comment) {
		this.admin_comment = admin_comment;
	}
	

	public Date getAdded_date() {
		return added_date;
	}
	

	public void setAdded_date(Date added_date) {
		this.added_date = added_date;
	}
	

	public Date getUpdated_date() {
		return updated_date;
	}
	

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}


	@Override
	public String toString() {
		return "FounderMeter [id=" + id + ", name=" + name + ", linkedin_link=" + linkedin_link + ", auth_meter="
				+ auth_meter + ", admin_comment=" + admin_comment + ", added_date=" + added_date + ", updated_date="
				+ updated_date + "]";
	}
}