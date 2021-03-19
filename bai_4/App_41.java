package DBclass.bai_4;

import DBclass.Laptop_Database.Counter;
import DBclass.Laptop_Database.LaptopServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class App_41 {
    //    select maker,count(*) as quantity from laptop group by maker order by count(*) desc;
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
            String databaseUrl = "jdbc:mysql://localhost:3306/sore_cms_plusplus?characterEncoding=utf8";
            String user = "root";
            String pass = "duongmich";
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/store_cms_plusplus?characterEncoding=utf8", "root", "duongmich");
            System.out.println("SQL Connection to database established!");

            LaptopServices laptopServices = new LaptopServices(connection);
            List<Counter> result = laptopServices.getCounterByMaker();
            System.out.println( result );

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console" + e);
            return;
        }
    }
}
