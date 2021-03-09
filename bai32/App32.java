package DBclass.bai32;

import DBclass.bai_3_1.Laptop;
import DBclass.bai_3_1.LaptopServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class App32 {
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
            String databaseUrl = "jdbc:mysql://localhost:3306/store_cms_plusplus?characterEncoding=utf8";
            String user = "root";
            String pass = "duongmich";
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/store_cms_plusplus?characterEncoding=utf8", "root", "duongmich");
            System.out.println("SQL Connection to database established!");

            LaptopServices laptopServices = new LaptopServices(connection);
            List<Laptop> laptops = laptopServices.findLaptopBySelection(8000000f,38000000f,null,null,null,null,null,null,null);
            for (Laptop laptop: laptops
                 ) {
                System.out.println(laptop.getName()+", Maker :"+ laptop.getMaker()+", Screen size: "+ laptop.getScreen_size()+", RAM: "+ laptop.getRam()+", CPU: "+ laptop.getCpu()+", Card: "+ laptop.getCard()+", Price: "+ laptop.getPrice());
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console" + e);
            return;
        }
    }
}
