package ca.ucalgary.farmersmarketapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Farmers_Market_Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmers__market__main);
    }

    public void buttonOnePressed(View view) {
        Intent myIntent = new Intent(view.getContext(), Sales.class);
        startActivityForResult(myIntent, 0);
    }

}