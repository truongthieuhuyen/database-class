package DBclass.bai_5;

import DBclass.Laptop_Database.Laptop;
import DBclass.Laptop_Database.LaptopServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class App_52 {
    public static void main(String[] args) {
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
            return;
        }
        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;
        try {
            String databaseUrl = "jdbc:mysql://localhost:3306/store_cms_plusplus?characterEncoding=utf8";
            String user = "root";
            String pass = "duongmich";
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/store_cms_plusplus?characterEncoding=utf8", "root", "duongmich");
            System.out.println("SQL Connection to database established!");

            LaptopServices laptopServices = new LaptopServices(connection);
//            laptopServices.addLaptopToDatabase(7,"Laptop Apple MacBook Pro 13\" 2019 MV972SA/A (Core i5/8GB/512GB SSD/Iris Plus Graphics 655/macOS/1.4 kg)","https://phongvu.vn/may-tinh-xach-tay-laptop-macbook-pro-2019-133-mv972saa-xam-s190800752.html","APPLE","MacBook Pro","8GB","Intel Core i5","512GB",null,52000000f,"Intel Iris Plus Graphics 655"," 2560 x 1600",13.3f,14);
//            laptopServices.deleteLaptop(8);
            laptopServices.updateLaptopHasSold(5,5);
            List<Laptop> laptops = laptopServices.findLaptopBySelection(null,null,5,null,null,null,null,null,null,null);
            System.out.println(laptops);;
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console"  + e);
            return;
        }
    }
}
