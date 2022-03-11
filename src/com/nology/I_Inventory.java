package com.nology;

import java.util.List;

public interface I_Inventory {

    String addNewItemsToInventory(String name, int quantity);

    void updateItemQuantity(String name, int quantity);

    void removeItemsFromInventory(String name, int quantity);

    OfficeItem findItem(String name);
}
