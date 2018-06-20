package com.JDBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Technologies used Oracle Express Database 11g
//driver library ojdbc6.jar
public class JDBConnection {

	public static void main(String[] args){
		
		Statement tStatement=null;
		Connection tConnection = null;
		//ResultSet rs;
		
		try{
				//loading driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//connT1= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","javauser","Password");
			
			tConnection= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","javauser","password");
			//tConnection= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","hr","password");
			/*	NOTE	
			 "jdbc:oracle:thin:@localhost:1521:xe","Admin","Password"
			 Connection URL:"jdbc:oracle:thin:@localhost:1521:xe"
			 API:jdbc
			 Database: oracle
			 Driver: oracle.jdbc.driver.OracleDriver
			 The type of driver:thin
			 IP Address:@localhost
			 Port:1521
			 Oracle service ID: xe (enterprise eddition)
			 */
		
			//Statement tStatement=tConnection.createStatement(); //create query
			tStatement=tConnection.createStatement(); //create query
						
			String sql="select * from hr.CLIENT";
			//String sqlUPDATE="UPDATE CLIENTS SET CLIENTID=4 where CLIENTID=2";
			
			//stT2.executeUpdate(sqlUPDATE);
			//int a = stT2.executeUpdate(sqlUPDATE);
			//System.out.println(a);
			//ResultSet rs=stT1.executeQuery(sql);
			ResultSet rs=tStatement.executeQuery(sql);
			
		//	
			while(rs.next()){
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getInt(5));
			}
			//tConnection.close();
			System.out.println("Done!");
		}
		catch (SQLException e){
			System.out.println(e);
		}
		catch(Exception e){
		System.out.println(e);
		//connT1.close();
		}
		finally{
			try {tConnection.close();
			}
			catch(SQLException e){
				System.out.println(e);
			}
		}
		
		
	}
}
