package DBclass.bai_3_1;

import java.sql.Timestamp;

public class Laptop {
    Integer id;
    String name;
    String url;
    String maker;
    String type;
    String ram;
    String cpu;
    String ssd;
    String hdd;
    Float price;
    String card;
    String screen_resolution;
    Float screen_size;
    Integer sold;
    Timestamp created_timestamp;
    Timestamp last_updated_timestamp;


    public Laptop(Integer id, String name, String maker, Float price) {
        this.id = id;
        this.name = name;
        this.maker = maker;
        this.price = price;
    }

    public Laptop(String name, String maker, String hdd, String ssd) {
        this.name = name;
        this.maker = maker;
        this.hdd = hdd;
        this.ssd = ssd;
    }

    public Laptop(String name,String maker, Float screen_size, String ram, String cpu, String card,Float price) {
        this.name = name;
        this.maker = maker;
        this.screen_size = screen_size;
        this.ram = ram;
        this.cpu = cpu;
        this.card = card;
        this.price = price;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getSsd() {
        return ssd;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getScreen_resolution() {
        return screen_resolution;
    }

    public void setScreen_resolution(String screen_resolution) {
        this.screen_resolution = screen_resolution;
    }

    public Float getScreen_size() {
        return screen_size;
    }

    public void setScreen_size(Float screen_size) {
        this.screen_size = screen_size;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public Timestamp getCreated_timestamp() {
        return created_timestamp;
    }

    public void setCreated_timestamp(Timestamp created_timestamp) {
        this.created_timestamp = created_timestamp;
    }

    public Timestamp getLast_updated_timestamp() {
        return last_updated_timestamp;
    }

    public void setLast_updated_timestamp(Timestamp last_updated_timestamp) {
        this.last_updated_timestamp = last_updated_timestamp;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", maker='" + maker + '\'' +
                ", type='" + type + '\'' +
                ", ram='" + ram + '\'' +
                ", cpu='" + cpu + '\'' +
                ", ssd='" + ssd + '\'' +
                ", hdd='" + hdd + '\'' +
                ", price=" + price +
                ", card='" + card + '\'' +
                ", screen_resolution='" + screen_resolution + '\'' +
                ", screen_size=" + screen_size +
                ", sold=" + sold +
                ", created_timestamp=" + created_timestamp +
                ", last_updated_timestamp=" + last_updated_timestamp +
                '}';
    }
}
