package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQL_Connection {
	public static Connection Connector()
	{
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:ShipBuilding.sqlite");
			return conn;
		}catch(Exception e){
			return null;
		}
		
	}

}
