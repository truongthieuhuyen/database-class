package DBclass.bai_3_1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App_31 {

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

            /*
            Query DB
            1. Viết hàm tìm kiếm laptop theo khoảng giá từ x đến y. (x và y có thể ko đồng thời có mawtj) => check null
            2. Viết hàm tìm kiếm laptop theo loại ổ cứng và hãng sản xuất. VD(haangx: asus, ổ ssd)
             */
            LaptopServices laptopServices = new LaptopServices(connection);
            List<Laptop> laptops = laptopServices.findLaptopByPrice(null,30000000f);
            for (Laptop laptop :laptops){
                System.out.println(laptop.getId()+". "+ laptop.getName()+", maker: "+ laptop.getMaker()+", price: "+ laptop.getPrice());
            }

            List<Laptop> laptops1 = laptopServices.findLaptopByMaker("ASUS","hdd",null);
            for (Laptop laptop1: laptops1
                 ) {
                System.out.println("\n"+laptop1.getName()+", maker: "+ laptop1.getMaker()+", hdd: "+ laptop1.getHdd()+", ssd: "+ laptop1.getSsd());
            }

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console" + e);
            return;
        }
    }

}
