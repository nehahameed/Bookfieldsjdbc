import java.sql.*;
import java.util.Scanner;

public class Insertbooks {

    public static void insertBookData() {
        String url = "jdbc:mysql://127.0.0.1:3306/Bookfields";
        String username = "root";
        String password = "0904";
        String queryCheck = "SELECT COUNT(*) FROM books WHERE BookId = ?";
        String queryInsert = "INSERT INTO books (BookId, Title, ISBN, Publisher, PublicationDate, Price, CostPrice, StockQuantity, LanguageName, Edition, PageCount, BookFormat, BookDescription, BookCoverImage) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement pstCheck = con.prepareStatement(queryCheck);
             PreparedStatement pstInsert = con.prepareStatement(queryInsert);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter book Id:");
            int bookId = scanner.nextInt();
            scanner.nextLine(); 

           
            pstCheck.setInt(1, bookId);
            ResultSet rs = pstCheck.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count > 0) {
                System.out.println("Book ID already exists. Please enter a different ID.");
                return;
            }

            System.out.println("Enter book title:");
            String bookTitle = scanner.nextLine();


            System.out.println("Enter ISBN:");
            String isbn = scanner.nextLine();


            System.out.println("Enter publisher:");
            String publisher = scanner.nextLine();

            System.out.println("Enter publication date (YYYY-MM-DD):");
            String publicationDate = scanner.nextLine();

            System.out.println("Enter price:");
            double price = scanner.nextDouble();

            System.out.println("Enter cost price:");
            double costPrice = scanner.nextDouble();

            System.out.println("Enter stock quantity:");
            int stockQuantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline after integer input

            System.out.println("Enter language name:");
            String languageName = scanner.nextLine();

            System.out.println("Enter edition:");
            String edition = scanner.nextLine();

            System.out.println("Enter page count:");
            int pageCount = scanner.nextInt();
            scanner.nextLine(); // Consume newline after integer input

            System.out.println("Enter book format:");
            String bookFormat = scanner.nextLine();

            System.out.println("Enter book description:");
            String bookDescription = scanner.nextLine();

            System.out.println("Enter book cover image:");
            String bookCoverImage = scanner.nextLine();

            // Set parameters for the insert statement
            pstInsert.setInt(1, bookId);
            pstInsert.setString(2, bookTitle);
            pstInsert.setString(3, isbn);
            pstInsert.setString(4, publisher);
            pstInsert.setString(5, publicationDate);
            pstInsert.setDouble(6, price);
            pstInsert.setDouble(7, costPrice);
            pstInsert.setInt(8, stockQuantity);
            pstInsert.setString(9, languageName);
            pstInsert.setString(10, edition);
            pstInsert.setInt(11, pageCount);
            pstInsert.setString(12, bookFormat);
            pstInsert.setString(13, bookDescription);
            pstInsert.setString(14, bookCoverImage);

            // Execute the insert statement
            pstInsert.executeUpdate();
            System.out.println("Book inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        insertBookData();
    }
}
