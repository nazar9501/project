package com.softserve.app.entity;

import javax.persistence.*;

@Entity
@Table
public class Exhibit {
	
	@Id
	@Column(name = "IDEXHIBIT")
	@GeneratedValue
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "IDHALL")
	private Long hall;
	
	@ManyToOne
    @JoinColumn(name = "IDAUTHOR")
	private Long author;
	
	@Column
	private String name;
	
	@Column
	private String material;
	
	@Column
	private String technique;
	
	public Exhibit() {
		
	}
	
	public void setId(Long id) {
	    this.id = id;
	}
	
	public void setHall(Long hall) {
	    this.hall = hall;
	}
	
	public void setAuthor(Long author) {
	    this.author = author;
	}
	
	public void setName(String name) {
	    this.name = name;
	}
	
	public void setMaterial(String material) {
	    this.material = material;
	}
	
	public void setTechnique(String technique) {
	    this.technique = technique;
	}
	
	public Long getId() {
	    return id;
	}
	
	public Long getHall() {
	    return hall;
	}
	
	public Long getAuthor() {
	    return author;
	}
	
	public String getName() {
	    return name;
	}
	
	public String getMaterial() {
	    return material;
	}
	
	public String getTechnique() {
	    return technique;
	}

}
