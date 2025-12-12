package JDBC;

import java.sql.*;
import java.util.Scanner;

public class Jdbc_StudentManagementSystem {
	public static void main(String[] args) throws Exception {
		// Step 1: Register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2: Create Connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");

		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n----- Student Management System -----");
			System.out.println("1. Add Student");
			System.out.println("2. View All Students");
			System.out.println("3. Search by Roll No");
			System.out.println("4. Delete Student");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Enter Student RollNo : ");
				int rollNo = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Name : ");
				String name = sc.nextLine();
				System.out.print("Enter Student Age : ");
				int age = sc.nextInt();
				sc.nextLine();
				PreparedStatement insertStmt = con.prepareStatement("INSERT INTO management (rollNo,name,age) VALUES (?,?,?)");
				insertStmt.setInt(1, rollNo);
				insertStmt.setString(2, name);
				insertStmt.setInt(3, age);
				insertStmt.executeUpdate();
				System.out.println("✅ Book Inserted Successfully!");
				break;

			case 2:
				Statement viewStmt = con.createStatement();
				ResultSet rs = viewStmt.executeQuery("SELECT * FROM management");
				System.out.println("\n Students List:");
				while (rs.next()) {
					System.out.println("Student RollNo : " + rs.getInt("rollNo") 
					+ " | Student Name : " + rs.getString("name")+ " | Student Age : " + rs.getString("age"));
				}
				break;

			case 3:
			    System.out.print("Enter Student RollNo to Search : ");
			    int searchRoll = sc.nextInt();

			    PreparedStatement searchStmt = con.prepareStatement("SELECT * FROM management WHERE rollNo = ?");
			    searchStmt.setInt(1, searchRoll);
			    ResultSet searchRs = searchStmt.executeQuery();

			    if (searchRs.next()) {
			        System.out.println("\n--- Student Found ---");
			        System.out.println("Roll No : " + searchRs.getInt("rollNo"));
			        System.out.println("Name    : " + searchRs.getString("name"));
			        System.out.println("Age     : " + searchRs.getInt("age"));
			    } else {
			        System.out.println("❌ Student not found.");
			    }
			    break;

			case 4:
				System.out.print("Enter Student RollNo to delete: ");
				int deleteId = sc.nextInt();
				PreparedStatement deleteStmt = con.prepareStatement("DELETE FROM student WHERE rollNo = ?");
				deleteStmt.setInt(1, deleteId);
				int deleted = deleteStmt.executeUpdate();
				if (deleted > 0)
					System.out.println("✅ Details Deleted!");
				else
					System.out.println("❌ Details not found.");
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