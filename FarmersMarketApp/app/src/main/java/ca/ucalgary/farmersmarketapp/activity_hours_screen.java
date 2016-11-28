package ca.ucalgary.farmersmarketapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class activity_hours_screen extends AppCompatActivity {

    //such oo, WOW
    public static boolean hourgenerate = true;
    public static ArrayList <employee> employeeListHour = new ArrayList<employee>();
    public boolean favorite = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hours_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //extreme oo here
        if (hourgenerate){
            generateEmployees();
        }
        hourgenerate = false;


        customHoursAdapter adapter = new customHoursAdapter(employeeListHour, this);

        ListView listView = (ListView) findViewById(R.id.employeeList1);
        listView.setAdapter(adapter);
    }


    public void generateEmployees (){
        employee e1 = new employee("John", "Doe");
        e1.addRole("Manager");
        employeeListHour.add(e1);
        employee e2 = new employee("Don", "Doe");
        employeeListHour.add(e2);
        employee e3 = new employee("Ming", "Doe");
        employeeListHour.add(e3);
        employee e4 = new employee("Phone", "Doe");
        employeeListHour.add(e4);
        employee e5 = new employee("John", "Rando");
        employeeListHour.add(e5);
        employee e6 = new employee("Donald", "Lukinuk");
        employeeListHour.add(e6);
        employee e7 = new employee("Mac", "Donald");
        employeeListHour.add(e7);
        employee e8 = new employee("Rando", "Person");
        employeeListHour.add(e8);
        employee e9 = new employee("Candice", "Dorm");
        employeeListHour.add(e9);
        employee e10 = new employee("Jason", "Person");
        employeeListHour.add(e10);
        employee e11 = new employee("Employee", "One");
        employeeListHour.add(e11);
        employee e12 = new employee("Employee", "Two");
        employeeListHour.add(e12);
        employee e13 = new employee("Employee", "Three");
        employeeListHour.add(e13);
        employee e14 = new employee("Employee", "Four");
        employeeListHour.add(e14);
        employee e15 = new employee("Employee", "Five");
        employeeListHour.add(e15);
        employee e16 = new employee("Employee", "Six");
        employeeListHour.add(e16);
        employee e17 = new employee("Employee", "Seven");
        e17.addRole("Cleaner");
        employeeListHour.add(e17);
    }

}
