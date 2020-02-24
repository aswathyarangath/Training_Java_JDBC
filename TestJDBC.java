package databasedemo;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/connectdb","root","aswathy*7");
		Statement stmt=con.createStatement();
		// executing query
		ResultSet rs=stmt.executeQuery("Select * from employee1");
		while(rs.next()){
			//displaying data of tables
			System.out.println("ID : "+rs.getInt("id")+" Name : "+rs.getString("name")+" Department : "+rs.getString("dept")+" Salary : "+rs.getInt("salary"));
		}
		System.out.println("Query executed.");
		String sq1="update employee1 set salary=10000 where id=501;";
	
		stmt.executeUpdate(sq1);
		System.out.println("One row updated");

		con.close();
		
	}

}
