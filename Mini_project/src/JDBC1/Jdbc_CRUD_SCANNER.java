package JDBC1;

import java.sql.*;

import java.util.Scanner;

public class Jdbc_CRUD_SCANNER {

    public static void main(String[] args) throws Exception {

        // Step 1: Register Driver

        Class.forName("com.mysql.cj.jdbc.Driver");


        // Step 2: Create Connection

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pro2", "root", "");


        Scanner sc = new Scanner(System.in);

        int choice;


        do {

            System.out.println("\n----- Book Management Menu -----");

            System.out.println("1. Insert Book");

            System.out.println("2. View All Books");

            System.out.println("3. Update Book");

            System.out.println("4. Delete Book");

            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            sc.nextLine(); // clear buffer


            switch (choice) {

                case 1:

                    System.out.print("Enter book title: ");

                    String title = sc.nextLine();

                    PreparedStatement insertStmt = con.prepareStatement("INSERT INTO books (title) VALUES (?)");

                    insertStmt.setString(1, title);

                    insertStmt.executeUpdate();

                    System.out.println("✅ Book Inserted Successfully!");

                    break;


                case 2:

                    Statement viewStmt = con.createStatement();

                    ResultSet rs = viewStmt.executeQuery("SELECT * FROM books");

                    System.out.println("\n📚 Book List:");

                    while (rs.next()) {

                        System.out.println("ID: " + rs.getInt("id") + " | Title: " + rs.getString("book"));

                    }

                    break;


                case 3:

                    System.out.print("Enter book ID to update: ");

                    int updateId = sc.nextInt();

                    sc.nextLine(); // clear buffer

                    System.out.print("Enter new title: ");

                    String newTitle = sc.nextLine();

                    PreparedStatement updateStmt = con.prepareStatement("UPDATE books SET book = ? WHERE id = ?");

                    updateStmt.setString(1, newTitle);

                    updateStmt.setInt(2, updateId);

                    int updated = updateStmt.executeUpdate();

                    if (updated > 0)

                        System.out.println("✅ Book Updated!");

                    else

                        System.out.println("❌ Book ID not found.");

                    break;


                case 4:

                    System.out.print("Enter book ID to delete: ");

                    int deleteId = sc.nextInt();

                    PreparedStatement deleteStmt = con.prepareStatement("DELETE FROM books WHERE id = ?");

                    deleteStmt.setInt(1, deleteId);

                    int deleted = deleteStmt.executeUpdate();

                    if (deleted > 0)

                        System.out.println("✅ Book Deleted!");

                    else

                        System.out.println("❌ Book ID not found.");

                    break;

                case 5:

                    System.out.println("👋 Exiting...");

                    break;

                default:

                    System.out.println("❌ Invalid choice. Please try again.");

            }

        } while (choice != 5);

        con.close();

        sc.close();

    }

}