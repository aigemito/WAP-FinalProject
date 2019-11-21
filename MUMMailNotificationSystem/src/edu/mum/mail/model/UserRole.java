package edu.mum.mail.model;

import java.io.Serializable;

public class UserRole implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int roleId;
	private String role;
	
	
	public UserRole() {
		
	}
	public UserRole(int roleId, String role) {
		this.roleId=roleId;
		this.role=role;
		
	}
	public int getRoleId() {
		return roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
