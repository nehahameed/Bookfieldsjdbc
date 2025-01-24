import java.sql.*;
import java.util.Scanner;

public class Updatebooks {

    public static void updateBookPrice() {
        String url ="jdbc:mysql://127.0.0.1:3306/Bookfields";
        String username = "root";
        String password ="0904";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the new price: ");
            double newPrice = scanner.nextDouble();

            String query = "UPDATE books SET Price = ? WHERE Price = '15.99'";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setDouble(1, newPrice);
            pst.executeUpdate();

            con.close();
            System.out.println("Success");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        updateBookPrice();
    }
}