package com.travel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long roleid;
	
	
	private String role;

	
	
	
	
	

	public Role() {
		
	}


	public Long getRoleid() {
		return roleid;
	}


	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	
	
	
}
