package models;

import java.util.Objects;

public class TransactionItem extends Item {

    private Integer quantity;


    public TransactionItem(String plu, String name, Double price, Integer quantity) {
        super(plu, name, price);
        this.quantity = quantity;
    }

    public TransactionItem(String plu, String name, Double price) {
        super(plu, name, price);
        this.quantity = 1;
    }

    public Integer getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionItem that = (TransactionItem) o;
        return Objects.equals(super.getPlu(), that.getPlu());
    }

    @Override
    public Double getPrice() {
        return quantity * super.getPrice();
    }

    public String toString() {
        return super.getName() + "\t\t" + quantity + "@" + super.getPrice() + "\t\t" + getPrice();
    }
}
