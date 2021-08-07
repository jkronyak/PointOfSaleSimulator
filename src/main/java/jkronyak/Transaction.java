package jkronyak;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Transaction {

    static int transactionCount;
    private String transactionID;

    private ObservableList<String> itemList;



    public Transaction() {
        transactionID = Integer.toString(transactionCount);
        transactionCount++;
        itemList = FXCollections.observableArrayList();
    }

    public void addItem(String itemToAdd)
    {
        //System.out.println("In addItem()");
        itemList.add(itemToAdd);
        //System.out.println("New list content: " + itemList);
    }

    public ObservableList<String> getItemList(){
        return itemList;
    }


    public String getTransactionID(){
        return transactionID;
    }

}
