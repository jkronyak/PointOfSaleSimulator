package models;

import java.io.Serializable;

public class Item implements Serializable {

    private String plu;
    private String name;
    private Double price;

    public Item() {
        this.plu = "0";
        this.name = "unnamed";
        this.price = 0.0;
    }

    public Item(String plu, String name, Double price) {
        this.plu = plu;
        this.name = name;
        this.price = price;
    }

    public Item(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public String getPlu() {
        return plu;
    }

    public void setPlu(String plu) {
        this.plu = plu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }



    @Override
    public String toString(){
        return name + "\t\t\t" + price;
    }



}
