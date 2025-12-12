package JDBC1;



import java.sql.*;

public class Jdbc_con {

public static void main(String[] args) throws SQLException {


  

try {

Class.forName("com.mysql.cj.jdbc.Driver");

}

catch(Exception e){

System.out.println(e.toString());

}




 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pro1","root","");




Statement stmt = con.createStatement();




ResultSet rs = stmt.executeQuery("select * from student");


while(rs.next()) {

System.out.println(rs.getInt(1)+"\t" + rs.getString(2));

}

}

}

