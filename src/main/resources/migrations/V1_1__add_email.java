package migrations;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

public class V1_1__add_email implements JdbcMigration {

	private static final String ALTER_CONTACT_TABLE_SQL = "ALTER TABLE contact ADD COLUMN email VARCHAR(45) NULL AFTER phone_number;";

	private static final String INSERT_EMAIL1 = "update contact set email = 'f@gmail.com' where name = 'lance';";
	private static final String INSERT_EMAIL2 = "update contact set email = 'b@yahoo.com' where name = 'bill';";
	private static final String INSERT_EMAIL3 = "update contact set email = 't@hotmail.com' where name = 'tony';";
	private static final String INSERT_EMAIL4 = "update contact set email = 'harry@gmail.com' where name = 'harry';";
	
	@Override
	public void migrate(Connection connection) throws Exception {
        PreparedStatement createTblStatement =
            connection.prepareStatement(ALTER_CONTACT_TABLE_SQL);
        
        PreparedStatement insertRecords1 =
                connection.prepareStatement(INSERT_EMAIL1);
        PreparedStatement insertRecords2 =
                connection.prepareStatement(INSERT_EMAIL2);
        PreparedStatement insertRecords3 =
                connection.prepareStatement(INSERT_EMAIL3);
        PreparedStatement insertRecords4 =
                connection.prepareStatement(INSERT_EMAIL4);        

        try {
        	createTblStatement.execute();
        	insertRecords1.execute();
        	insertRecords2.execute();
        	insertRecords3.execute();
        	insertRecords4.execute();
        } finally {
        	createTblStatement.close();
        	insertRecords1.close();
        	insertRecords2.close();
        	insertRecords3.close();
        	insertRecords4.close();
        }
    }

}
