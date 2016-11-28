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

public class employees_screen extends AppCompatActivity {

    //such oo, WOW
    public static boolean generate = true;
    public static ArrayList <employee> employeeList = new ArrayList<employee>();
    public boolean favorite = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //@android:drawable/star_big_off
                FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab);
                if (favorite){
                    fab1.setImageResource(android.R.drawable.star_big_off);
                    favorite = false;
                    Snackbar.make(view, "Favorite Removed", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else {
                    fab1.setImageResource(android.R.drawable.star_big_on);
                    favorite = true;
                    Snackbar.make(view, "Favorite Added", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        //extreme oo here
        if (generate){
            generateEmployees();
        }
        generate = false;


        customEmployeeAdapter adapter = new customEmployeeAdapter(this, employeeList, this);

        ListView listView = (ListView) findViewById(R.id.employeeList);
        listView.setAdapter(adapter);
    }


    public void generateEmployees (){
        employee e1 = new employee("John", "Doe");
        e1.addRole("Manager");
        employeeList.add(e1);
        employee e2 = new employee("Don", "Doe");
        employeeList.add(e2);
        employee e3 = new employee("Ming", "Doe");
        employeeList.add(e3);
        employee e4 = new employee("Phone", "Doe");
        employeeList.add(e4);
        employee e5 = new employee("John", "Rando");
        employeeList.add(e5);
        employee e6 = new employee("Donald", "Lukinuk");
        employeeList.add(e6);
        employee e7 = new employee("Mac", "Donald");
        employeeList.add(e7);
        employee e8 = new employee("Rando", "Person");
        employeeList.add(e8);
        employee e9 = new employee("Candice", "Dorm");
        employeeList.add(e9);
        employee e10 = new employee("Jason", "Person");
        employeeList.add(e10);
        employee e11 = new employee("Employee", "One");
        employeeList.add(e11);
        employee e12 = new employee("Employee", "Two");
        employeeList.add(e12);
        employee e13 = new employee("Employee", "Three");
        employeeList.add(e13);
        employee e14 = new employee("Employee", "Four");
        employeeList.add(e14);
        employee e15 = new employee("Employee", "Five");
        employeeList.add(e15);
        employee e16 = new employee("Employee", "Six");
        employeeList.add(e16);
        employee e17 = new employee("Employee", "Seven");
        e17.addRole("Cleaner");
        employeeList.add(e17);
    }

}
