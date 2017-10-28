package com.api.rest.dto;

public class LocationDTO {
	
	private String order_code;
	private String de_code;
	private String latitude;
	private String longitude;
	
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	public String getDe_code() {
		return de_code;
	}
	public void setDe_code(String de_code) {
		this.de_code = de_code;
	}
}
