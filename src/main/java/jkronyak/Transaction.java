package jkronyak;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Transaction {

    private static int transactionCount;

    private String transactionID;
    private ObservableList<Item> itemList;
    private ItemDAO itemDAO;



    public Transaction() {
        transactionID = Integer.toString(transactionCount);
        transactionCount++;
        itemList = FXCollections.observableArrayList();
        itemDAO = new ItemDAO();

    }

    public void addItem(String plu)
    {
        Item itemToAdd = itemDAO.get(Integer.parseInt(plu));
        if(itemToAdd != null) {
            itemList.add(itemToAdd);
        } else
        {
            System.out.println("ITEM NOT FOUND");
        }

        //itemList.add(itemToAdd);
    }

    public ObservableList<Item> getItemList(){
        return itemList;
    }


    public String getTransactionID(){
        return transactionID;
    }

}
