package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class Transaction {

    private static int transactionCount;

    private String transactionID;
    private ObservableList<TransactionItem> itemList;
    private ItemDAO itemDAO;



    public Transaction() {
        transactionID = Integer.toString(transactionCount);
        transactionCount++;
        itemList = FXCollections.observableArrayList();
        itemDAO = new ItemDAO();

    }

    public void addItem(String plu) throws SQLException {
        TransactionItem itemToAdd = (TransactionItem) itemDAO.get(plu);

        if(itemToAdd != null) {
            if(itemList.contains(itemToAdd)) {
                TransactionItem foundItem = null;
                for(int i = 0; i < itemList.size(); i++) {
                    if( itemList.get(i).equals(itemToAdd) ) {
                        itemToAdd.setQuantity(itemList.get(i).getQuantity() + 1);

                        itemList.set(i, itemToAdd);
                        System.out.println("FOUND");
                    }
                }
            } else {
                itemList.add(itemToAdd);
            }


        } else {
            System.out.println("ITEM NOT FOUND");
            throw new NullPointerException("Item not on file");
        }

        //itemList.add(itemToAdd);
    }

    public ObservableList<TransactionItem> getItemList(){
        return itemList;
    }

    public double getTotal(){

        double total = 0;
        for(TransactionItem item : itemList) {
            total += item.getPrice();
        }
        return total;

    }

    public String getTransactionID(){
        return transactionID;
    }

}
