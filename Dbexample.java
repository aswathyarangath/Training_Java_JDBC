package databasedemo;
import java.sql.*;
public class Dbexample {

	public static void main(String[] args) throws Exception{
		String url="jdbc:mysql://localhost:3306/connectdb";
		String username="root";
		String password="aswathy*7";
		
		String sql1="create table employee(id int,name varchar(10),salary int,dept varchar(10));";
		String sql2="insert into employee values(123,'manu',300000,'sales');";
		
				
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		Statement st=con.createStatement();
		
		//st.executeUpdate(sql1);
		//System.out.println("Table created.");
		st.executeUpdate(sql2);
		System.out.println("Values inserted.");
		
		st.close();
		con.close();
		
	}

}
