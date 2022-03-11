package com.nology;

public class OfficeItem {
    private String itemName;
    private int itemQuantity;

    public OfficeItem(String itemName, int itemQuantity) {
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public int maxBasedOnAllowance(int allowance){

        return getItemQuantity() / allowance;
    }

    @Override
    public String toString() {
        return "OfficeItem{" +
                "itemName='" + itemName + '\'' +
                ", itemQuantity=" + itemQuantity +
                '}';
    }
}
