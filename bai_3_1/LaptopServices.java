package DBclass.bai_3_1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LaptopServices {
    Connection connection;

    public LaptopServices(Connection connection) {
        this.connection = connection;
    }

    /*
    findLaptopByPrice
     */
    public List<Laptop> findLaptopByPrice(Float minPrice, Float maxPrice) {
        List<Laptop> response = new ArrayList<>();
        try {
            String query = "SELECT * FROM laptop WHERE true";
            if (minPrice != null) {
                query = query + "AND price >= " + minPrice;
            }
            if (maxPrice != null) {
                query = query + " AND price <= " + maxPrice;
            }
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String maker = resultSet.getString("maker");
                Float price = resultSet.getFloat("price");

                Laptop laptop = new Laptop(id, name, maker, price);
                response.add(laptop);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return response;
    }

    /*
    findLaptopByMaker
     */
    public List<Laptop> findLaptopByMaker(String maker, String hdd, String ssd) throws SQLException {
        List<Laptop> response1 = new ArrayList<>();
        try {
            String query = "SELECT * FROM store_cms_plusplus.laptop WHERE true ";
            if (maker != null) {
                query = query + "AND maker = '" + maker + "'";
            }
            if (hdd != null) {
                query = query + " AND hdd IS NOT NULL ";
            }
            if (ssd != null) {
                query = query + " AND ssd IS NOT NULL ";
            }
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                maker = resultSet.getString("maker");
                hdd = resultSet.getString("hdd");
                ssd = resultSet.getString("ssd");

                Laptop laptop1 = new Laptop(name, maker, hdd, ssd);
                response1.add(laptop1);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return response1;
    }

    /*
    findLaptopBySelection
     */
    public List<Laptop> findLaptopBySelection(Float minPrice, Float maxPrice,String name, String maker, Float screen_size, String ram, String cpu, String card, Float price) {
        List<Laptop> response3_2 = new ArrayList<>();
        try {
            String query = "SELECT * FROM  laptop WHERE true ";
            if (name != null){
                query = query +"AND name = "+ name+"'";
            }
            if (maker != null) {
                query = query + "AND maker = '" + maker + "'";
            }
            if (screen_size != null) {
                query = query + "AND screen_size = '" + screen_size + "'";
            }
            if (ram != null) {
                query = query + "AND ram = '" + ram + "'";
            }
            if (cpu != null) {
                query = query + "AND cpu = '" + cpu + "' ";
            }
            if (card != null) {
                query = query + "AND card = '" + card + "' ";
            }
            if (minPrice != null) {
                query = query + "AND price >= " + minPrice;
            }
            if (maxPrice != null) {
                query = query + " AND price <= " + maxPrice;
            }
//            query = query + "ORDER BY price DESC;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                name = resultSet.getString("name");
                maker = resultSet.getString("maker");
                screen_size = resultSet.getFloat("screen_size");
                ram = resultSet.getString("ram");
                cpu = resultSet.getString("cpu");
                card = resultSet.getString("card");
                price = resultSet.getFloat("price");

                Laptop laptop = new Laptop(name,maker,screen_size,ram,cpu,card,price);
                response3_2.add(laptop);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return response3_2;
    }

    /*
    4.1 getCounterByMaker
     */
    public List<DBclass.bai_3_1.Counter> getCounterByMaker(String maker, Integer quantity){
        List<DBclass.bai_3_1.Counter> response = new ArrayList<>();
        try {
            String sql = "select maker,count(*) as quantity from laptop group by maker order by quantity desc";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                maker = resultSet.getString("maker");
                quantity = resultSet.getInt("quantity");

                Counter counter = new Counter(maker, quantity);
                response.add(counter);
            }
        }
        catch (Exception e){
            System.out.println("ERROR: "+e);
        }
        return response;
    }
}
