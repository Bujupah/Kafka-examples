/**
 * 
 */
package com.bmc.ade.reporting.usermanagement.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author abjadhav
 *
 */
@JsonSerialize
@JsonIgnoreProperties
public class TMSEvent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("data")
	private transient Object data;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	

}
