package JDBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Technologies used Oracle Express Database 11g
//driver library ojdbc6.jar
public class JDBConnection {

	public static void main(String[] args){
		
		Statement stT2=null;
		Connection connT1 = null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//connT1= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","javauser","Password");
			
			connT1= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","javauser","Password");
			/*		
			 "jdbc:oracle:thin:@localhost:1521:xe","Admin","Password"
			 Connection URL:"jdbc:oracle:thin:@localhost:1521:xe"
			 API:jdbc
			 Database: oracle
			 The type of driver:thin
			 IP Address:@localhost
			 Port:1521
			 Oracle service ID: xe (enterprise eddition)
			 */
		
			Statement stT1=connT1.createStatement(); //create query
			stT2=connT1.createStatement(); //create query
			
		    
			
			String sql="select * from hr.CLIENT";
			//String sqlUPDATE="UPDATE CLIENTS SET CLIENTID=4 where CLIENTID=2";
			
			//stT2.executeUpdate(sqlUPDATE);
			//int a = stT2.executeUpdate(sqlUPDATE);
			//System.out.println(a);
			System.out.println("tu2");
			ResultSet rs=stT1.executeQuery(sql);
			
		//	
			while(rs.next()){
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getInt(5));
			}
			connT1.close();
			System.out.println("Success madafaka!");
		}
		catch (SQLException e){
			System.out.println(e);
		}
		catch(Exception e){
		System.out.println(e);
		//connT1.close();
		}
		
		
	}
}
