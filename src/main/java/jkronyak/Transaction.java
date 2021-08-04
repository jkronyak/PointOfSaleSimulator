package jkronyak;

import java.util.ArrayList;

public class Transaction {

    static int transactionCount;
    private String transactionID;

    private ArrayList<Item> itemArrayList;



    public Transaction() {
        transactionID = Integer.toString(transactionCount);
        transactionCount++;
        itemArrayList = new ArrayList<Item>();
    }

    public void addItem(Item itemToAdd)
    {
        itemArrayList.add(itemToAdd);
    }

    public String getTransactionID(){
        return transactionID;
    }

}
