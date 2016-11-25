package ca.ucalgary.farmersmarketapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Whoosp on 2016-11-14.
 */
public class Products extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_screen);
    }

    public void inventoryPressed(View view) {
        Intent myIntent = new Intent(view.getContext(), inventory_item_screen.class);
        startActivityForResult(myIntent, 0);
    }



}
