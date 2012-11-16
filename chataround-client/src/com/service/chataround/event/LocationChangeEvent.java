package com.service.chataround.event;

import java.io.Serializable;
import java.math.BigDecimal;

public class LocationChangeEvent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigDecimal latitude ;
	private BigDecimal longitude;
	public LocationChangeEvent (BigDecimal latitude,BigDecimal longitude){
		this.latitude=latitude;
		this.longitude=longitude;
	}
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	} 
	
}
