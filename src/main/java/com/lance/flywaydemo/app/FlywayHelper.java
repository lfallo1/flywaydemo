package com.lance.flywaydemo.app;

import java.util.ResourceBundle;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;
import org.flywaydb.core.api.MigrationInfoService;

public class FlywayHelper {
	private static final String APP_PROPERTIES_PATH = "app";
	private Flyway flyway = null;
	private String url;
	private String username;
	private String password;
	private String locations;
	
	public FlywayHelper(){
		ResourceBundle bundle = ResourceBundle.getBundle(APP_PROPERTIES_PATH);
		setUrl(bundle.getObject("url").toString());
		setUsername(bundle.getObject("user").toString());
		setPassword(bundle.getObject("password").toString());
		setLocations(bundle.getObject("locations").toString());
		
		flyway = new Flyway();
		flyway.setDataSource(url, username, password);
		flyway.setLocations(locations);			
		flyway.setCallbacks(new FlywayCallbacks());
	}

	public void migrateToVersion(String version, Boolean clean){
		if(clean){
			flyway.clean();
		}
		flyway.setCleanOnValidationError(true);
		flyway.setTarget(version);
		flyway.migrate();
		flyway.setTarget(flyway.info().all()[flyway.info().all().length-1].getVersion().getVersion());
	}
	
	public String getInfo(){
		MigrationInfoService service = flyway.info();
		StringBuilder sb = new StringBuilder();
		for (MigrationInfo info : service.all()) {
			sb.append(String.format("<<version %s>>\t<<description %s>>\t<<state %s>>\r\n", info.getVersion().getVersion(), info.getDescription(), info.getState().getDisplayName()));
		}	
		return sb.toString();
	}

	public Flyway getFlyway() {
		return flyway;
	}

	public void setFlyway(Flyway flyway) {
		this.flyway = flyway;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocations() {
		return locations;
	}

	public void setLocations(String locations) {
		this.locations = locations;
	}
}
