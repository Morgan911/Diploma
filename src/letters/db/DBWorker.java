package letters.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DBWorker {

	private static DBWorker instance;
	
	private static String url;
	private static String db;
	private static String driver;
	private static String user;
	private static String password;

	Properties prop;
	Connection connection;

	private DBWorker(){
		prop = new Properties();
		FileInputStream in = null;
		try {
			in = new FileInputStream(new File("./database.properties"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			prop.load(in);

			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		driver = prop.getProperty("jdbc.driver");
		url = prop.getProperty("jdbc.url");
		db = prop.getProperty("jdbc.db");
		user = prop.getProperty("jdbc.username");
		password = prop.getProperty("jdbc.password");
	}
	
	public static DBWorker getInstance(){
		if(instance == null){
			instance = new DBWorker();
		}
		return instance;
	}
	
	/*private static final String CREATEKEYDATABASE = "CREATE TABLE IF NOT EXISTS `keys` (`key_id` int(11) NOT NULL AUTO_INCREMENT,"
			+ "`key_name` varchar(100) NOT NULL, `key_folder_id` int(11) NOT NULL,"
			+ "PRIMARY KEY (`key_id`),"
			+ "CONSTRAINT `key_folder_id` FOREIGN KEY (`key_folder_id`) "
			+ "REFERENCES `folders` (`folder_id`) ON DELETE CASCADE ON UPDATE CASCADE)"
			+ " ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=cp1250";

	private static final String CREATEMESSAGEDATABASE = "CREATE TABLE IF NOT EXISTS `messages` (`message_id` int(11) NOT NULL AUTO_INCREMENT,"
			+ "`message_title` varchar(100) NOT NULL,"
			+ "`message_text` longtext NOT NULL,"
			+ "`message_folder_id` int(11) NOT NULL,"
			+ "PRIMARY KEY (`message_id`),"
			+ "CONSTRAINT `message_folder_id` FOREIGN KEY (`message_folder_id`) REFERENCES `folders` (`folder_id`) ON DELETE CASCADE ON UPDATE CASCADE)"
			+ " ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=cp1250";

	private static final String CREATEFOLDERDATABASE = "CREATE TABLE IF NOT EXISTS   `folders` (`folder_id` int(11) NOT NULL AUTO_INCREMENT, "
			+ "`folder_name` varchar(100) NOT NULL,"
			+ " PRIMARY KEY (`folder_id`))"
			+ " ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=cp1250";*/

	public Connection openConnection() {
		try {
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection(url + db, user, password);
			try {
				createTables();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return null;
	}


	private void createTables() throws SQLException {
		/*PreparedStatement sttm1 = connection
				.prepareStatement(CREATEFOLDERDATABASE);
		PreparedStatement sttm2 = connection
				.prepareStatement(CREATEMESSAGEDATABASE);
		PreparedStatement sttm = connection.prepareStatement(CREATEKEYDATABASE);

		sttm1.executeUpdate();
		sttm2.executeUpdate();
		sttm.executeUpdate();
	*/
	}
}
