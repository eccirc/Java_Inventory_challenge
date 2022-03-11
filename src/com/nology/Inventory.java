package com.nology;

import java.util.ArrayList;
import java.util.List;

public class Inventory implements I_Inventory{

    private List<OfficeItem> inventory = new ArrayList<>();

    public Inventory() {
    }

    @Override
    public String addNewItemsToInventory(String name, int quantity) {
        OfficeItem tempItem = new OfficeItem(name, quantity);
        inventory.add(tempItem);
        return tempItem.getItemName();
    }


    @Override
    public OfficeItem findItem(String name) {
        return inventory.stream().filter(item -> name.equals(item.getItemName())).findFirst().orElse(null);
    }
    @Override
    public void updateItemQuantity(String name, int quantity) {
        OfficeItem tempItem = findItem(name);
        int currentAmount = tempItem.getItemQuantity();
        tempItem.setItemQuantity(currentAmount + quantity);

    }

    @Override
    public void removeItemsFromInventory(String name, int quantity) {
       OfficeItem foundItem = findItem(name);
        assert foundItem != null;
        if(foundItem.getItemQuantity() > 0) {
            foundItem.setItemQuantity(foundItem.getItemQuantity() - quantity);
        }

    }


}
