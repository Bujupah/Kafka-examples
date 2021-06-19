/**
 * 
 */
package com.bmc.ade.reporting.usermanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author abjadhav
 *
 */
@JsonSerialize
@JsonIgnoreProperties
public class TMSServiceActivationEvent {

	private String id;
	
	private String status;
	
	private Tenant tenant;
	
	private ADEService service;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public ADEService getService() {
		return service;
	}

	public void setService(ADEService service) {
		this.service = service;
	}
	
	
}
