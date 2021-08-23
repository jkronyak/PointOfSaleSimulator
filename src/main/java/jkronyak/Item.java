package jkronyak;

import java.io.Serializable;

public class Item implements Serializable {

    private Integer plu;
    private String name;
    private Double price;

    public Item(Integer plu, String name, Double price) {
        this.plu = plu;
        this.name = name;
        this.price = price;
    }

    public Item(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public Integer getPlu() {
        return plu;
    }

    public void setPlu(Integer plu) {
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
