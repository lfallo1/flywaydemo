package com.lance.flywaydemo.models;

import com.lance.flywaydemo.annotations.Column;
import com.lance.flywaydemo.annotations.PropertyName;
import com.lance.flywaydemo.annotations.TableName;
import com.lance.flywaydemo.annotations.TemplateConstructor;

@TableName(value = "contact")
public class Contact {
	@Column("id")
	private Integer id;
	@Column("name")
	private String name;
	@Column("phone_number")
	private String phoneNumber;
	@Column("email")
	private String email;

	public Contact() {
	}

	@TemplateConstructor
	public Contact(@PropertyName("id") Integer id,
			@PropertyName("name") String name,
			@PropertyName("phoneNumber") String phoneNumber,
			@PropertyName("email") String email) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", phoneNumber="
				+ phoneNumber + ", email=" + email + "]";
	}
}
