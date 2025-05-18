package lemonadestand.entity;

import java.util.Objects;

public class Customer implements Person {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3794595415717863667L;
	
	private Integer id;
	private String name;
	private String phoneNumber;
	
	public Customer(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	// Empty constructor as required by Jackson (for .json object deserialization)
	public Customer() {
	}

	public Customer(Integer id, String name, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getName() {
		return name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Customer {name=" + name + ", phoneNumber=" + phoneNumber + "}";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(name, other.name) && Objects.equals(phoneNumber, other.phoneNumber);
	}


	
	

}
