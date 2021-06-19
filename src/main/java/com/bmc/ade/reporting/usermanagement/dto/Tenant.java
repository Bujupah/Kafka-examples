/**
 * 
 */
package com.bmc.ade.reporting.usermanagement.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author abjadhav
 *
 */
@JsonSerialize
@JsonIgnoreProperties
public class Tenant implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("tenant_id")
	private long tenantId;
	
	@JsonProperty("tenant_name")
	private String tenantName;
	
	//private List<User> users;

	public long getTenantId() {
		return tenantId;
	}

	public void setTenantId(long tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	/*public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}*/
	
	

}
