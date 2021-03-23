package DBclass.Laptop_Database;

import DBclass.Laptop_Database.Counter;
import DBclass.Laptop_Database.Laptop;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.mysql.cj.xdevapi.InsertStatement;

import java.sql.*;
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
    public List<Laptop> findLaptopBySelection(Float minPrice, Float maxPrice,Integer id, String name, String maker, Float screen_size, String ram, String cpu, String card, Float price) {
        List<Laptop> response3_2 = new ArrayList<>();
        try {
            String query = "SELECT * FROM  laptop WHERE true ";
            if (id != null) {
                query = query + "AND id = '" + id + "'";
            }
            if (name != null) {
                query = query + "AND name = '" + name + "'";
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
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                String url = resultSet.getString("url");
                maker = resultSet.getString("maker");
                String type = resultSet.getString("type");
                ram = resultSet.getString("ram");
                cpu = resultSet.getString("cpu");
                String ssd = resultSet.getString("ssd");
                String hdd = resultSet.getString("hdd");
                price = resultSet.getFloat("price");
                card = resultSet.getString("card");
                String screen_resolution = resultSet.getString("screen_resolution");
                screen_size = resultSet.getFloat("screen_size");
                Integer sold = resultSet.getInt("sold");
                Timestamp created_timestamp = resultSet.getTimestamp("created_timestamp");
                Timestamp last_updated_timestamp = resultSet.getTimestamp("last_updated_timestamp");

                Laptop laptop = new Laptop(id,name,url,maker,type,ram,cpu,ssd,hdd,price,card,screen_resolution,screen_size,sold,created_timestamp,last_updated_timestamp);
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

    /*
    5.2: Viết tính năng cập nhật số lượng đã bán laptop -- updateLaptopHasSold
    Input: ID laptop, số lượng tăng thêm.
    Output: Cập nhật số lượng đã bán trong DB, cập nhật last_updated_timestamp cho bản ghi DB.
     */
    public void updateLaptopHasSold(Integer id, Integer sold){
        try {
            String update = "update laptop set sold = '"+sold+"',last_updated_timestamp = current_timestamp() where id = '"+id+"';";
            Statement updateStatement = connection.createStatement();
            updateStatement.executeUpdate(update);
            System.out.println("UPDATED row id ="+id);
        }catch (Exception e){
            System.out.println("ERROR");
        }
    }
}
