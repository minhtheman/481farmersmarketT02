package ca.ucalgary.farmersmarketapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Whoosp on 2016-11-17.
 */

public class People extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_screen);
    }

    public void rolesPressed(View view) {
        Intent myIntent = new Intent(view.getContext(), employees_screen.class);
        startActivityForResult(myIntent, 0);
    }

}
