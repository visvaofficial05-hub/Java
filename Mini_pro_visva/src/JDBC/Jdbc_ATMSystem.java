package JDBC;
import java.sql.*;
import java.util.*;

public class Jdbc_ATMSystem {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/atmsystem", "root", ""
        );

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n----- ATM MENU -----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account No: ");
                    int acc1 = sc.nextInt();

                    PreparedStatement balStmt = con.prepareStatement(
                            "SELECT balance, holderName FROM account WHERE accNo = ?"
                    );
                    balStmt.setInt(1, acc1);

                    ResultSet rs1 = balStmt.executeQuery();
                    if (rs1.next()) {
                        System.out.println("Name: " + rs1.getString("holderName"));
                        System.out.println("Balance: ₹" + rs1.getDouble("balance"));
                    } else {
                        System.out.println("Account Not Found!");
                    }
                    break;


                case 2:
                    System.out.print("Enter Account No: ");
                    int acc2 = sc.nextInt();

                    System.out.print("Enter Amount to Deposit: ");
                    double amountD = sc.nextDouble();

                    PreparedStatement depStmt = con.prepareStatement(
                            "UPDATE account SET balance = balance + ? WHERE accNo = ?"
                    );
                    depStmt.setDouble(1, amountD);
                    depStmt.setInt(2, acc2);

                    int rowsD = depStmt.executeUpdate();

                    if (rowsD > 0) {
                        System.out.println("Deposit Successful!");

                        PreparedStatement t1 = con.prepareStatement(
                                "INSERT INTO transactions (accNo, details) VALUES (?, ?)"
                        );
                        t1.setInt(1, acc2);
                        t1.setString(2, "Deposit ₹" + amountD);
                        t1.executeUpdate();

                    } else {
                        System.out.println("Account Not Found!");
                    }
                    break;


                case 3:
                    System.out.print("Enter Account No: ");
                    int acc3 = sc.nextInt();

                    System.out.print("Enter Amount to Withdraw: ");
                    double amountW = sc.nextDouble();

                    PreparedStatement balCheck = con.prepareStatement(
                            "SELECT balance FROM account WHERE accNo = ?"
                    );
                    balCheck.setInt(1, acc3);
                    ResultSet balRs = balCheck.executeQuery();

                    if (balRs.next()) {

                        double bal = balRs.getDouble("balance");

                        if (bal >= amountW) {
                            PreparedStatement widStmt = con.prepareStatement(
                                    "UPDATE account SET balance = balance - ? WHERE accNo = ?"
                            );
                            widStmt.setDouble(1, amountW);
                            widStmt.setInt(2, acc3);
                            widStmt.executeUpdate();

                            System.out.println("Withdraw Successful!");

                            PreparedStatement t2 = con.prepareStatement(
                                    "INSERT INTO transactions (accNo, details) VALUES (?, ?)"
                            );
                            t2.setInt(1, acc3);
                            t2.setString(2, "Withdraw ₹" + amountW);
                            t2.executeUpdate();

                        } else {
                            System.out.println("Insufficient Balance!");
                        }

                    } else {
                        System.out.println("Account Not Found!");
                    }
                    break;


                case 4:
                    System.out.print("Enter Account No: ");
                    int acc4 = sc.nextInt();

                    PreparedStatement mini = con.prepareStatement(
                            "SELECT details FROM transactions WHERE accNo = ? ORDER BY id DESC LIMIT 5"
                    );
                    mini.setInt(1, acc4);

                    ResultSet rsMini = mini.executeQuery();

                    System.out.println("\n--- MINI STATEMENT ---");
                    int count = 1;
                    while (rsMini.next()) {
                        System.out.println(count + ". " + rsMini.getString("details"));
                        count++;
                    }
                    break;

                case 5:
                    System.out.println("Exiting ATM...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        con.close();
    }
} 