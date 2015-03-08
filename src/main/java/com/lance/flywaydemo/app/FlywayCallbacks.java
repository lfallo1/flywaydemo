package com.lance.flywaydemo.app;

import java.sql.Connection;

import org.flywaydb.core.api.MigrationInfo;
import org.flywaydb.core.api.callback.FlywayCallback;

public class FlywayCallbacks implements FlywayCallback {

	@Override
	public void beforeClean(Connection connection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterClean(Connection connection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeMigrate(Connection connection) {
		System.out.println("Preparing for migration");
	}

	@Override
	public void afterMigrate(Connection connection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeEachMigrate(Connection connection, MigrationInfo info) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterEachMigrate(Connection connection, MigrationInfo info) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeValidate(Connection connection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterValidate(Connection connection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeBaseline(Connection connection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterBaseline(Connection connection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeInit(Connection connection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterInit(Connection connection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeRepair(Connection connection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterRepair(Connection connection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeInfo(Connection connection) {
		
	}

	@Override
	public void afterInfo(Connection connection) {
		System.out.println("Retreived Info");
	}

}
