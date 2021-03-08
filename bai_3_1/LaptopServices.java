package DBclass.bai_3_1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LaptopServices {
    Connection connection ;
    public LaptopServices(Connection connection){
        this.connection = connection;
    }
    public List<Laptop> findLaptopByPrice(Float minPrice, Float maxPrice){
        List<Laptop> response = new ArrayList<>();
        try {
            String query = "SELECT * FROM laptop WHERE true";
            if (minPrice != null){
                query = query + "AND price >= "+ minPrice;
            }
            if (maxPrice != null){
                query = query +" AND price <= "+ maxPrice;
            }
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String maker = resultSet.getString("maker");
                Float price = resultSet.getFloat("price");

                Laptop laptop = new Laptop(id,name,maker,price);
                response.add(laptop);
            }
        }
        catch (Exception e){
            System.out.println("Error: "+e);
        }
        return response;
    }

    public List<Laptop> findLaptopByMaker(String maker, String hdd, String ssd) throws SQLException {
        List<Laptop> response1 = new ArrayList<>();
        try {
            String query = "SELECT * FROM store_cms_plusplus.laptop WHERE true ";
            if (maker != null){
                query = query + "AND maker = '" + maker+"'";
            }
            if (hdd != null){
                query = query + " AND hdd IS NOT NULL ";
            }
            if (ssd != null){
                query = query + " AND ssd IS NOT NULL ";
            }
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String name = resultSet.getString("name");
                maker = resultSet.getString("maker");
                hdd = resultSet.getString("hdd");
                ssd = resultSet.getString("ssd");

                Laptop laptop1 = new Laptop(name,maker,hdd,ssd);
                response1.add(laptop1);
        }
            }
        catch (Exception e){
                System.out.println("Eror: " + e);
            }
        return response1;
    }
}
