package DBclass.Laptop_Database;

import DBclass.Laptop_Database.Counter;
import DBclass.Laptop_Database.Laptop;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.mysql.cj.xdevapi.InsertStatement;

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
    3.1 findLaptopByMaker
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
    3.2 findLaptopBySelection
     */
    public List<Laptop> findLaptopBySelection(Float minPrice, Float maxPrice, String name, String maker, Float screen_size, String ram, String cpu, String card, Float price) {
        List<Laptop> response3_2 = new ArrayList<>();
        try {
            String query = "SELECT * FROM  laptop WHERE true ";
            if (name != null) {
                query = query + "AND name = " + name + "'";
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

                Laptop laptop = new Laptop(name, maker, screen_size, ram, cpu, card, price);
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
    public List<Counter> getCounterByMaker() {
        List<Counter> response = new ArrayList<>();
        try {
            String sql = "select maker,count(*) as quantity from laptop group by maker order by quantity desc";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String maker = resultSet.getString("maker");
                Integer quantity = resultSet.getInt("quantity");

                Counter counter = new Counter(maker, quantity);
                response.add(counter);
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return response;
    }

    /*
    4.2 Viết chức năng thống kê số lượng, số tiền bán được của mỗi hãng -- getStatisticByMaker
     */
    public List<Statistic> getStatisticByMaker() {
        List<Statistic> response = new ArrayList<>();
        try {
            String sql = "select maker,sum(sold) as total_sold,sum(price*sold) as total_money from laptop group by maker";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String maker = resultSet.getString("maker");
                Integer sold = resultSet.getInt("total_sold");
                Float totalMoney = resultSet.getFloat("total_money");
                Statistic statistic = new Statistic(maker, sold, totalMoney);
                response.add(statistic);
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return response;
    }

    /*
    5.1 Viết tính năng thêm laptop vào danh mục sản phẩm -- addLapTopToDatabase
    Output: Insert vào DB
    Hàm test: Search trong DB sản phẩm có tên giống tên vừa thêm vào => output có dữ liệu
     */
    public void addLaptopToDatabase(Integer id, String name, String url, String maker, String type, String ram, String cpu, String ssd, String hdd, Float price, String card, String screen_resolution, Float screen_size, Integer sold) {
        List<Laptop> response = new ArrayList<>();
        try {
            String insert = "INSERT INTO `store_cms_plusplus`.`laptop` (`id`, `name`, `url`, `maker`, `type`, `ram`, `cpu`, `ssd`, `hdd`, `price`, `card`, `screen_resolution`, `screen_size`, `sold`) VALUES ('"+id+"', '"+name+"', '"+url+"', '"+maker+"', '"+type+"', '"+ram+"', '"+cpu+"', '"+ssd+"', '"+hdd+"', '"+price+"', '"+card+"', '"+screen_resolution+"', '"+screen_size+"', '"+sold+"');";

            Statement insertStatement = connection.createStatement();
            insertStatement.execute(insert);
            System.out.println("INSERTED SUCCESSFUL");
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
    //delete records in laptop
    public void deleteLaptop(Integer id){
        try {
            String delete = "DELETE FROM `store_cms_plusplus`.`laptop` WHERE (`id` = '"+id+"');";
            Statement deleteStatement = connection.createStatement();
            deleteStatement.execute(delete);
            System.out.println("DELETED row id = '"+id+"'");
        } catch (Exception e){
            System.out.println("ERROR :"+e);
        }
    }
}
