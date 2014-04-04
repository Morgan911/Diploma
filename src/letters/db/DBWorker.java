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
	
	public Connection openConnection() {
		try {
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection(url + db);//, user, password);
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

	}
}
