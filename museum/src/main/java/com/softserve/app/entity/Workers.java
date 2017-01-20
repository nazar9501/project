package com.softserve.app.entity;

import javax.persistence.*;

@Entity
@Table
public class Workers {
	
	@Id
	@Column(name = "IDWORKER")
	@GeneratedValue         
	private Long id;
	
	@Column
	private String first_name;
	
	@Column
	private String last_name;
	
	@Column
	private String post;
	
	public Workers() {
		
	}
	
	public void setId(Long id) {
	    this.id = id;
	}
	
	public void setFirst_name(String first_name) {
	    this.first_name = first_name;
	}
	
	public void setLast_name(String last_name) {
	    this.last_name = last_name;
	}
	
	public void setPost(String post) {
	    this.post = post;
	}
	
	public Long getId() {
	    return id;
	}
	
	public String getFirst_name() {
	    return first_name;
	}
	
	public String getLast_name() {
	    return last_name;
	}
	
	public String getPost() {
	    return post;
	}

}
