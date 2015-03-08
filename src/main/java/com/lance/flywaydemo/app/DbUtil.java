package com.lance.flywaydemo.app;

import java.util.ResourceBundle;

import org.apache.tomcat.jdbc.pool.DataSource;

import com.lance.flywaydemo.dao.ContactDao;

public class DbUtil {
	private static final String APP_PROPERTIES_PATH = "app";
	private ContactDao contactDao;
	private DataSource dataSource;

	public DbUtil(){
		setupDatabaseConnection();
		contactDao = new ContactDao();
		contactDao.setJdbcTemplate(dataSource);
	}
	private void setupDatabaseConnection() {
		ResourceBundle bundle = ResourceBundle.getBundle(APP_PROPERTIES_PATH);
		dataSource = new DataSource();
		dataSource.setUrl(bundle.getString("url"));
		dataSource.setUsername(bundle.getString("user"));
		dataSource.setPassword(bundle.getString("password"));
		dataSource.setDriverClassName(bundle.getString("driver"));
	}
	
	public ContactDao getContactDao() {
		return contactDao;
	}
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
	
}
