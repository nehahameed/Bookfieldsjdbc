import java.sql.*;
public class Deletebooks {

	   public static void deletebook() throws Exception{
			String url ="jdbc:mysql://127.0.0.1:3306/Bookfields";
			String username = "root";
			String password ="0904";
			String Query = "delete from books where BookId = '5'";
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement pst = con.prepareStatement(Query);
			pst.executeUpdate();
			con.close();
			System.out.println("Success");
		}
	   
	   
	   
	   public static void main(String[] args) throws Exception {
		deletebook();
	}
	}
