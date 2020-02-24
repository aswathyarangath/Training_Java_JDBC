package databasedemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchExample {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/connectdb","root","aswathy*7");
		long startTime=System.currentTimeMillis();
		Statement st=con.createStatement();
		st.addBatch("Insert into employee(id,name,salary,dept)" + "values(124,'vinu',3000,'sales')");
		st.addBatch("Insert into employee(id,name,salary,dept)" + "values(987,'anu',4000,'tech')");
		st.executeBatch();
		long endTime=System.currentTimeMillis();
		long time=endTime-startTime;
		System.out.println("Query done in : "+time +" milliseconds");
		con.close();
	}

}
