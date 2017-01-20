package com.softserve.app.entity;

import javax.persistence.*;

@Entity
@Table
public class Schedule {
	
	@Id
	@Column(name = "IDSCHEDULE")
	@GeneratedValue
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "IDEXURSION")
	private Long exursion;
	
	@Column
	private String date_start;
	
	@Column
	private String date_end;
	
	public Schedule() {
		
	}
	
	public void setId(Long id) {
	    this.id = id;
	}
	
	public void setExursion(Long exursion) {
	    this.exursion = exursion;
	}
	
	public void setDate_start(String date_start) {
	    this.date_start = date_start;
	}
	
	public void setDate_end(String date_end) {
	    this.date_end = date_end;
	}
	
	public Long getId() {
	    return id;
	}
	
	public Long getExursion() {
	    return exursion;
	}
	
	public String getDate_start() {
	    return date_start;
	}
	
	public String getDate_end() {
	    return date_end;
	}

}
