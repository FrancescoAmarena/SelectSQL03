package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url="jdbc:mysql://localhost:3306/newdb";
        String username="developer";
        String password="passwordhere";
        Connection connection=null;


        try {
            connection= DriverManager.getConnection(url,username,password);
            Statement stmt = connection.createStatement();
            ResultSet rs=stmt.executeQuery("Select first_name , last_name from students;");
            while(rs.next()){
                System.out.println(rs.getString("first_name"));}
            ResultSet rs2=stmt.executeQuery("Select last_name from students;");
            ArrayList<String> surnames=new ArrayList<>();
            while(rs2.next()){
                surnames.add(rs2.getString("last_name"));}
            String[] myArray = surnames.toArray(new String[4]);
            System.out.println(Arrays.toString(myArray));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}