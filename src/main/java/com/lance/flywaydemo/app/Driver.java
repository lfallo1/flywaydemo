package com.lance.flywaydemo.app;

import org.flywaydb.core.Flyway;

import com.lance.flywaydemo.models.Contact;
import com.lance.flywaydemo.models.Favorite;



public class Driver {

	public static void main(String[] args) {
		Flyway flyway = new FlywayHelper().getFlyway();
		flyway.migrate();
		DbUtil db = new DbUtil();
		for (Contact c : db.getContactDao().getAll()) {
			System.out.println(c.toString());
		}
		for (Favorite f : db.getFavoriteDao().getAll()) {
			System.out.println(f.toString());
		}
	}
}
