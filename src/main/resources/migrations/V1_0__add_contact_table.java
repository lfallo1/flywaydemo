package migrations;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

public class V1_0__add_contact_table implements JdbcMigration {

	private static final String CREATE_CONTACT_TABLE_SQL = "CREATE TABLE contact (id INT NOT NULL AUTO_INCREMENT, name VARCHAR(45) NULL, phone_number VARCHAR(45) NULL, PRIMARY KEY (id), UNIQUE INDEX id_UNIQUE (id ASC));";
	private static final String INSERT_RECORDS = "INSERT INTO contact (name, phone_number) VALUES ('lance', '4438373837'), ('bill', '3837636371'), ('tony', '9383736373'), ('harry', '3383736353');";  
	
	@Override
	public void migrate(Connection connection) throws Exception {
        PreparedStatement createTblStatement =
            connection.prepareStatement(CREATE_CONTACT_TABLE_SQL);
        
        PreparedStatement insertRecords =
                connection.prepareStatement(INSERT_RECORDS);

        try {
        	createTblStatement.execute();
        	insertRecords.execute();
        } finally {
        	createTblStatement.close();
        	insertRecords.close();
        }
    }

}
