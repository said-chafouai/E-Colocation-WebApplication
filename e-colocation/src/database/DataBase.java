package database;
import java.sql.*;

public class DataBase {
	
	public static Connection connection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/colocation","root","");
		return myConn ;
	}

}

