import java.sql.*;
import java.util.Scanner;

public class Deletebooks {

    public static void deletebook() {
        String url = "jdbc:mysql://127.0.0.1:3306/Bookfields";
        String username = "root";
        String password = "0904";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the BookId to delete: ");
        String bookId = scanner.nextLine();

        String query = "DELETE FROM books WHERE BookId = ?";
        
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, bookId);
            int rowsAffected = pst.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Success: Book with BookId " + bookId + " has been deleted.");
            } else {
                System.out.println("No book found with BookId " + bookId + ".");
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void main(String[] args) {
        deletebook();
    }
}
```
