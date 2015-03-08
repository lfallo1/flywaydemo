package com.lance.flywaydemo.app;

import org.flywaydb.core.Flyway;

import com.lance.flywaydemo.models.Contact;



public class Driver {

	public static void main(String[] args) {
		Flyway flyway = new FlywayHelper().getFlyway();
		flyway.setTarget("1.1");
		flyway.migrate();
		DbUtil db = new DbUtil();
		for (Contact c : db.getContactDao().getAll()) {
			System.out.println(c.toString());
		}
	}
}
