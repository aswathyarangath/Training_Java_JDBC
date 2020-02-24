package databasedemo;
import java.sql.*;

public class TransactionDemo {
	

	public static void main(String[] args) throws Exception {
	// TODO Auto-generated method
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;

	try{

	String url="jdbc:mysql://localhost:3306/dbdemo";
	String username="root";
	String password="Aspvpc@1";
	String sql1="create table emp(emp_id int not null primary key,emp_name varchar(30));";
	String sql2="insert into emp values('711','raj');";
	String sql3="insert into emp values('311','sahana');";
	String sql4="select * from emp where emp_id=1";
	String sql5="select * from emp where emp_id=? and emp_name=? ";
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection(url,username,password);
	con.setAutoCommit(false);
	 ps=con.prepareStatement(sql5);
	ps.setString(2,"swetha");
	ps.setInt(1,2);
	rs=ps.executeQuery();
	if(rs.next()){
	//System.out.println("success");
	System.out.println(rs.getInt(1));
	}
	else{
	System.out.println("not success");
	}
	ResultSetMetaData rsmd=rs.getMetaData();
	System.out.println(rsmd.getColumnCount());
	System.out.println(rsmd.getColumnName(1));
	System.out.println(rsmd.getColumnTypeName(1));
	long starttime=System.currentTimeMillis();

	Statement st=con.createStatement();

	st.addBatch(sql3);
	st.addBatch(sql2);
	st.executeBatch();
	long endtime=System.currentTimeMillis();
	System.out.println("addbatch time");

	System.out.println(endtime-starttime);

	con.commit();

	st.close();
	// ResultSet rs=st.executeQuery(sql4);
	// while(rs.next()){
	// System.out.println(rs.getInt(1)+"    "+rs.getString(2));
	// }
	//st.executeUpdate(sql1);
	//st.executeUpdate(sql2);
	//st.executeUpdate(sql3);
	//System.out.println("table created");
	//System.out.println("inserted");
	//st.close();
	}
	finally{
	try{

	if(rs!=null)
	rs.close();
	if(ps!=null)
	ps.close();
	if(con!=null)
	con.rollback();
	System.out.println("roll backed");
	con.close();

	}catch(SQLException e){
	e.printStackTrace();
	}
	}
	}}

