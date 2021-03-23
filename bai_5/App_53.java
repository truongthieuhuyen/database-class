package DBclass.bai_5;

import DBclass.Laptop_Database.Laptop;
import DBclass.Laptop_Database.LaptopServices;
import DBclass.Student_Database.Department;
import DBclass.Student_Database.StudentManagementProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class App_53 {
    public static void main(String[] args) {
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
            return;
        }
        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;
        try {
            String databaseUrl = "jdbc:mysql://localhost:3306/manage_student?characterEncoding=utf8";
            String user = "root";
            String pass = "duongmich";
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/manage_student?characterEncoding=utf8", "root", "duongmich");
            System.out.println("SQL Connection to database established!");

//            LaptopServices laptopServices = new LaptopServices(connection);
//            System.out.println(laptops);
            StudentManagementProgram studentManagementProgram = new StudentManagementProgram(connection);
            studentManagementProgram.updateNoOfStudent("SE","0");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console" + e);
            return;
        }
    }
}
