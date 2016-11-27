package ca.ucalgary.farmersmarketapp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
        Date initTime = new Date();
        Date tempTime = new Date();
        tempTime.setTime(initTime.getTime()- TimeUnit.MINUTES.toMillis(15));
        tempatureLog.add(new Integer(15));
        dateLog.add(tempTime);
        tempTime.setTime(initTime.getTime()-TimeUnit.MINUTES.toMillis(10));
        tempatureLog.add(new Integer(-15));
        dateLog.add(tempTime);
        tempTime.setTime(initTime.getTime()-TimeUnit.MINUTES.toMillis(5));
        tempatureLog.add(new Integer(25));
        dateLog.add(tempTime);
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
