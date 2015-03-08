package com.lance.flywaydemo.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.flywaydb.core.api.MigrationInfo;
import org.flywaydb.core.api.callback.FlywayCallback;

public class FlywayCallbacks implements FlywayCallback {

	private static final String CREATE_FLYWAY_TRACKER_TBLE = "CREATE TABLE if not exists flyway_tracker (id INT NOT NULL AUTO_INCREMENT, command VARCHAR(45) NOT NULL, date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, PRIMARY KEY (id), UNIQUE INDEX id_UNIQUE (id ASC));";
	
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
		
	}

	@Override
	public void beforeEachMigrate(Connection connection, MigrationInfo info) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterEachMigrate(Connection connection, MigrationInfo info) {
		StringBuilder sb = new StringBuilder();
		sb.append("Migration to version " + info.getVersion().getVersion() + " has completed.");
		sb.append(String.format("<<version %s>>\t<<description %s>>\t<<state %s>>\r\n", info.getVersion().getVersion(), info.getDescription(), info.getState().getDisplayName()));
		System.out.println(sb.toString());
		createFlywayTrackerTable(connection);
		updateFlywayTrackerTable("Migrate to " + info.getVersion().getVersion(), connection);
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
		createFlywayTrackerTable(connection);
		updateFlywayTrackerTable("Info", connection);
	}

	private void createFlywayTrackerTable(Connection connection) {
        PreparedStatement createTblStatement = null;   
        try {
        	createTblStatement = connection.prepareStatement(CREATE_FLYWAY_TRACKER_TBLE);
        	createTblStatement.execute();
        }
        catch(SQLException e){
        	e.printStackTrace();
        } finally {
        	try {
				createTblStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }		
	}
	
	private void updateFlywayTrackerTable(String command, Connection connection) {
		PreparedStatement statement = null;
        
        try {
        	statement = connection.prepareStatement("INSERT INTO flyway_tracker (command) VALUES (?);");
        	statement.setString(1, command);
        	statement.execute();
        }
        catch(SQLException e){
        	e.printStackTrace();
        } finally {
        	try {
        		statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }	
	}		
	
}
