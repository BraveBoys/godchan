<%-- <%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
request.setCharacterEncoding("utf-8");

String frame = request.getParameter("frame");
String wall = request.getParameter("wall");
String fire = request.getParameter("fire");
String user = request.getParameter("user");
String exit = request.getParameter("exit");
String door = request.getParameter("door");
String beacon = request.getParameter("beacon");

try
{
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://192.168.0.103:8080/ibeacon?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC";
	
	Connection conn = DriverManager.getConnection(url, "root", "1q2w3e4r5t");
	
	String sql = "INSERT INTO MAP (FRAME, WALL, FIRE, USER, EXIT, DOOR, BEACON) VALUES";
	
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, frame);
	pstmt.setString(2, wall);
	pstmt.setString(3, fire);
	pstmt.setString(4, user);
	pstmt.setString(5, exit);
	pstmt.setString(6, door);
	pstmt.setString(7, beacon);
	
	pstmt.executeUpdate();
	
	pstmt.close();
	conn.close();
	
	
} catch(ClassNotFoundException e) {
	out.println(e);
} catch(SQLException e) {
	out.println(e);
}

%> --%>