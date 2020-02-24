package databasedemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class PrepareStatement {

public static void main(String[] args)throws Exception {


Class.forName("com.mysql.cj.jdbc.Driver");
Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/connectdb","root","aswathy*7");

String st="select * from employee1 where id=? and name=?";
PreparedStatement ps=c.prepareStatement(st);

ps.setInt(1,501);
ps.setString(2,"Ritu");

ResultSet rs=ps.executeQuery();

if(rs.next())
{
System.out.println(" Id: "+rs.getInt(1)+" Name: "+rs.getString(2));
}
else
{
System.out.println("unsuccessfull");
}
ps.close();
c.close();


}
}

