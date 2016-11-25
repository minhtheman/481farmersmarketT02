package ca.ucalgary.farmersmarketapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Farmers_Market_Main_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmers__market__main);
    }

    public void salesPressed(View view) {
        Intent myIntent = new Intent(view.getContext(), Sales.class);
        startActivityForResult(myIntent, 0);
    }

    public void peoplePressed(View view) {
        Intent myIntent = new Intent(view.getContext(), People.class);
        startActivityForResult(myIntent, 0);
    }

    public void logsPressed(View view) {
        Intent myIntent = new Intent(view.getContext(), Logs.class);
        startActivityForResult(myIntent, 0);
    }

    public void productsPressed(View view) {
        Intent myIntent = new Intent(view.getContext(), Products.class);
        startActivityForResult(myIntent, 0);
    }

    public void settingsPressed(View view) {
        Intent myIntent = new Intent(view.getContext(), Settings.class);
        startActivityForResult(myIntent, 0);
    }

}