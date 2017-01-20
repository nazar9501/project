package com.softserve.app.entity;

import javax.persistence.*;

@Entity
@Table
public class Excursion {
	
	@Id
	@Column(name = "IDEXCURSION")
	@GeneratedValue
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "IDHALL")
	private Long hall;
	
	@ManyToOne
    @JoinColumn(name = "IDWORKER")
	private Long guide;
	
	@Column
	private String name;
	
	@Column
	private Float price;
	
	@Column
	private Integer duration_hours;
	
	@Column
	private Boolean done;
	
	public Excursion() {
		
	}
	
	public void setId(Long id) {
	    this.id = id;
	}
	
	public void setHall(Long hall) {
	    this.hall = hall;
	}
	
	public void setGuide(Long guide) {
	    this.guide = guide;
	}
	
	public void setName(String name) {
	    this.name = name;
	}
	
	public void setPrice(Float price) {
	    this.price = price;
	}
	
	public void setDuration_hours(Integer duration_hours) {
	    this.duration_hours = duration_hours;
	}
	
	public void setDone(Boolean done) {
	    this.done = done;
	}
	
	public Long getId() {
	    return id;
	}
	
	public Long getHall() {
	    return hall;
	}
	
	public Long getHuide() {
	    return guide;
	}
	
	public String getName() {
	    return name;
	}
	
	public Float getPrice() {
	    return price;
	}
	
	public Integer getDuration_hours() {
	    return duration_hours;
	}
	
	public Boolean getDone() {
	    return done;
	}

}
