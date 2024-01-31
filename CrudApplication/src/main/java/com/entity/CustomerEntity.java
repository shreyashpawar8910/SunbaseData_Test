package com.entity;

public class CustomerEntity {
	
	private String FirstName;
	private String LastName;
	private String Street;
	private String Address;
	private String City;
	private String State;
	private String Email;
	private String Phone;
	
	private String id;
	
	
	
	public CustomerEntity(String firstName, String lastName, String street, String address, String city, String state,
			String email, String phone, String id) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Street = street;
		Address = address;
		City = city;
		State = state;
		Email = email;
		Phone = phone;
		id = id;
	}
	
	
	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
