import java.sql.*;

public class Getbooks {
	
		public static void get() throws Exception {
			String url ="jdbc:mysql://127.0.0.1:3306/Bookfields";
			String username = "root";
			String password ="0904";
			String Query = "select * from books";
			Connection con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(Query);
			while (rs.next()) {
				System.out.println("book Id is: " + rs.getInt(1));
				System.out.println("book name is :" + rs.getString(2));
				System.out.println("book Author Id is:" + rs.getInt(3));
				System.out.println("book ISBN is:" + rs.getString(4));
				System.out.println("book Genre Id is:" + rs.getInt(5));
				System.out.println("book Publisher Name is:" + rs.getString(6));
				System.out.println("book Publication Date is:" + rs.getDate(7));
				System.out.println("book Price is:" + rs.getInt(8));
				System.out.println("book CostPrice is:" + rs.getInt(9));
				System.out.println("book Stock quantity is:" + rs.getInt(10));
				System.out.println("book Lnaguage is:" + rs.getString(11));
				System.out.println("book Edition is:" + rs.getString(12));
				System.out.println("book Pagecount is:" + rs.getInt(13));
				System.out.println("book Format is:" + rs.getString(14));
				System.out.println("book Deszcription is:" + rs.getString(15));
				System.out.println("book Cover Id is:" + rs.getString(16));
				
			}
			con.close();
			
		}
		
		public static void main(String[] args) throws Exception {
			get();

	}
	}
