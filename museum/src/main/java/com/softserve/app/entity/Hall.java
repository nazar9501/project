package com.softserve.app.entity;

import javax.persistence.*;

@Entity
@Table
public class Hall {
	
	@Id
	@Column(name = "IDHALL")
	@GeneratedValue
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "IDWORKER")
	private Long worker;
	
	@Column
	private String name;
	
	public Hall() {
		
	}
	
	public void setId(Long id) {
	    this.id = id;
	}
	
	public void setWorker(Long worker) {
	    this.worker = worker;
	}
	
	public void setName(String name) {
	    this.name = name;
	}
	
	public Long getId() {
	    return id;
	}
	
	public Long getWorker() {
	    return worker;
	}
	
	public String getName() {
	    return name;
	}
	
}
