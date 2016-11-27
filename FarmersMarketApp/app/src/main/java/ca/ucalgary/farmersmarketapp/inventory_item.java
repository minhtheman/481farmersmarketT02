package ca.ucalgary.farmersmarketapp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
        this.initTemp();
    }

    private void initTemp(){
        Random rng = new Random();
        Date initTime = new Date();
        int numEntries = rng.nextInt(7)+3; // generate between 3-10 entries
        Date tempTime = new Date(initTime.getTime() - TimeUnit.MINUTES.toMillis(5*numEntries));
        tempatureLog.add(new Integer(10 + rng.nextInt(5)));
        dateLog.add(tempTime);
        for (int i=1; i< numEntries; i++) {
            int newRand = rng.nextInt(10)-5; // random number between -5 to 5
            tempTime = new Date(initTime.getTime() - TimeUnit.MINUTES.toMillis(5*(numEntries-i)));
            tempatureLog.add(new Integer(tempatureLog.get(i-1).intValue() + newRand));
            dateLog.add(tempTime);
        }
    }

    public void addTempature(int temp){
        Date d = new Date();
        dateLog.add(d);
        tempatureLog.add(new Integer(temp));
    }

    public void addQuantity(int addValue){
        quantity = quantity + addValue;
    } // adds to stock

    public String getName(){
        return name;
    }

    public int getQuantity(){
        return quantity;
    }

    public int getLogSize(){
        return tempatureLog.size();
    }

    public int tempAt(int index){
        return tempatureLog.get(index);
    }

    public Date dateAt(int index){
        return dateLog.get(index);
    }
}
