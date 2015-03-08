package com.lance.flywaydemo.app;

import com.lance.flywaydemo.models.Contact;



public class Driver {

	public static void main(String[] args) {
		FlywayHelper flywayHelper = new FlywayHelper();
		//flywayHelper.migrateToVersion("1.0", true);
		flywayHelper.getFlyway().setTarget("1.0");
		flywayHelper.getFlyway().migrate();
		DbUtil db = new DbUtil();
		for (Contact c : db.getContactDao().getAll()) {
			System.out.println(c.toString());
		}
	}

}
