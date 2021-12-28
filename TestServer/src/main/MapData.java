package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MapData {
	private String driverName;
	private String url;
	private String id;
	private String password;
	
	public MapData() {
		this.driverName = "com.mysql.jdbc.Driver";
		this.url = "jdbc:mysql://192.168.0.103:8080/ibeacon?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC";
		this.id = "root";
		this.password = "1q2w3e4r5t";
	}
	
	private Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(this.driverName);
		return DriverManager.getConnection(this.url, this.id, this.password);
	}
	
	public void Map_Arr(MapDataDTO mapdata) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO MAP (FRAME, WALL, FIRE, USER, EXIT, DOOR, BEACON) VALUES"
					+"('"+mapdata.getStrArr()+"')'";
			stmt.executeUpdate(sql);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
