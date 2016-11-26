package ca.ucalgary.farmersmarketapp;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Whoosp on 2016-11-25.
 */

public class inventory_item {
    String name;
    int quantity;
    ArrayList <Integer> tempatureLog;
    ArrayList <Date> dateLog;

    public inventory_item (String pName){
        name = pName;
        quantity = 1;
        tempatureLog = new ArrayList<Integer>();
        dateLog = new ArrayList<Date>();
    }

    public void addTempature(int temp){
        Date d = new Date();
        dateLog.add(d);
        tempatureLog.add(new Integer(temp));
    }

    public void addQuantity(int addValue){
        quantity = quantity + addValue;
    }

    public String getName(){
        return name;
    }

    public int getQuantity(){
        return quantity;
    }
}
