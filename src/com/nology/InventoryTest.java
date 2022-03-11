package com.nology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
    public Inventory testInventory;
    public String[] items = {"pen", "stapler", "staples", "ruler", "A4 Booklet"};



    @BeforeEach
    void setUp() {
        //1000 pens, 200 staplers, 8000 staples, 50 rulers and 300
        //A4 Booklets
         testInventory = new Inventory();
        testInventory.addNewItemsToInventory(items[0], 1000);
        testInventory.addNewItemsToInventory(items[1], 200);
        testInventory.addNewItemsToInventory(items[2], 8000);
        testInventory.addNewItemsToInventory(items[3], 50);
        testInventory.addNewItemsToInventory(items[4], 300);
    }
//    If I remove 258 pens, how many do I have left?
//            • The office currently has 250 members of staff, each member of staff is to be issued with
//10 pens. How many more pens does the company need to acquire?
//            • If each stapler is supplied with 92 staples, will the company run out of staples or
//    staplers first?
//            • Staff have misplaced 63 rulers, how many new rulers must be ordered in order for the
//    company to have 300.
//            • Each new member of staff is given 5 pens, 1 stapler, 100 staples, 3 rules and 4 A4
//    booklets upon joining the company. How many members of staff could be hired based
//    on the current stock?



    @Test
    void findItemCanReturnAnItemName(){
        assertEquals("pen", testInventory.findItem("pen").getItemName());

    }
    @Test
    void removingAGivenNumberOfPensReturnsTheRightNewAmountOfPens(){
        int result = 1000 - 258;
        testInventory.removeItemsFromInventory(items[0], 258);
        assertEquals(result, testInventory.findItem(items[0]).getItemQuantity());
    }
    @Test
    void staplesOrStaplers(){
        int totalStaples = testInventory.findItem(items[1]).getItemQuantity() * 92;
        int invStaples = testInventory.findItem(items[2]).getItemQuantity();
        assertTrue(totalStaples > invStaples);

    }
    @Test
    void howManyRulersIfOverStockAreLost(){
        int result = 300 - (50 - 63);
        testInventory.removeItemsFromInventory(items[3], 63);
        testInventory.updateItemQuantity(items[3], result);
        assertEquals(300, testInventory.findItem(items[3]).getItemQuantity());
    }
    @Test
    void howManyStaffBasedOnCurrentStockShouldEqualSixteen(){

        int[] allowances = {5,1,100,3,4};

        List<Integer> totals = new ArrayList<>();

        for (int i = 0; i < allowances.length; i++) {
            totals.add(testInventory.findItem(items[i]).maxBasedOnAllowance(allowances[i]));
        }
        Collections.sort(totals);
        assertEquals(16, totals.get(0));

    }

}