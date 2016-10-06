package com.enterprise.capitalist.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LineOfBusiness implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5088387258699916825L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
 	@Column(name="id")
    private Long id;
	
	@Column(name="lob")
	String lob;
	
	@Column(name="description")
	String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLob() {
		return lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
