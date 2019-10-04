package com.deepesh.pojo;

import java.io.Serializable;

public class Address implements Serializable{

	private String street;
	private String city;
	private String state;
	private String country;
	private long pin;
	
	public Address() {
		super();
	}

	public Address(String street, String city, String state, String country, long pin) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pin = pin;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getPin() {
		return pin;
	}

	public void setPin(long pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "{ street:\"" + street + "\", city:\"" + city + "\", state:\"" + state + "\", country:\"" + country + "\", pin:"
				+ pin+" }";
	}
	
	
}
