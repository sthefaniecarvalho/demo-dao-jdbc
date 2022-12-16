package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		if (conn == null) {
			try {
				//String CLASSE_DRIVER = "com.mysql.cj.jdbc.Driver";
				String USUARIO = "geek";
				String SENHA = "university";
				String URL_SERVIDOR = "jdbc:mysql://localhost:3306/coursejdbc?useSSL=false";
				conn = DriverManager.getConnection(URL_SERVIDOR, USUARIO, SENHA);
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	
	public static void closeConnection() {
		if (conn != null) {
			
			try {
				conn.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
	}
	}
	
	public static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("C:\\Users\\Usuário\\eclipse-workspace\\javaDB\\src\\db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
			
		}catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
