package com.lance.flywaydemo.models;

import com.lance.flywaydemo.annotations.Column;
import com.lance.flywaydemo.annotations.PropertyName;
import com.lance.flywaydemo.annotations.TableName;
import com.lance.flywaydemo.annotations.TemplateConstructor;

@TableName(value = "favorite")
public class Favorite {
	@Column("id")
	private Integer id;
	@Column("contact")
	private Contact contact;

	public Favorite() {
	}

	@TemplateConstructor
	public Favorite(@PropertyName("id") Integer id,
			@PropertyName("contact") Integer contact_id) {
		Contact contact = new Contact();
		contact.setId(contact_id);
		this.id = id;
		this.contact = contact;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Favorite [id=" + id + ", contact=" + contact.getId() + "]";
	}

}
