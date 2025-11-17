package first_jdbc_app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) {
		try {
			//step1 
			Class.forName("com.mysql.cj.jdbc.Driver");//load and register driver class
			System.out.println("Driver class  loaded and  registered");
//			Connection con=DriverManager.getConnection("jdbc:mysql//localhost:3306","root","root");//  establish connection
			//step2
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company?user=root&password=root");
//			System.out.println(con);
			System.out.println("connection established.......");
			//step 3 : create statement
			Statement s=con.createStatement();
			System.out.println("statement created");
			s.execute("insert into emp values(1079,'allena',20000,10)");
			System.out.println("data saved successfully");
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}

}