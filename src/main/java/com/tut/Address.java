package com.tut;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "employee_address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int addressId;
	
	@Column(length=30, name = "CITY")
	private String city;
	
	@Column(length=50, name="STREET")
	private String street;
	
	@Transient
	private double x;
	
	@Column(name="is_open")
	private boolean isOpen;
	
	@Temporal(TemporalType.DATE)
	@Column(name="address_date")
	private Date addressdate;
	
	@Lob
	private byte[] image;

	public Address() {
		super();
	}

	public Address(int addressId, String city, String street, double x, boolean isOpen, Date addressdate,
			byte[] image) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.street = street;
		this.x = x;
		this.isOpen = isOpen;
		this.addressdate = addressdate;
		this.image = image;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public Date getAddressdate() {
		return addressdate;
	}

	public void setAddressdate(Date addressdate) {
		this.addressdate = addressdate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
