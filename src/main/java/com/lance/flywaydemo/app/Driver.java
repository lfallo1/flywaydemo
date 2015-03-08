package com.lance.flywaydemo.app;

import org.flywaydb.core.Flyway;

import com.lance.flywaydemo.models.Contact;

public class Driver {

	public static void main(String[] args) {
		FlywayHelper flywayHelper = new FlywayHelper();
		Flyway flyway = flywayHelper.getFlyway();
		flyway.migrate();
		DbUtil db = new DbUtil();
		for (Contact c : db.getContactDao().getAll()) {
			System.out.println(c.toString());
		}
		System.out.println(flywayHelper.getInfo());
	}
}
