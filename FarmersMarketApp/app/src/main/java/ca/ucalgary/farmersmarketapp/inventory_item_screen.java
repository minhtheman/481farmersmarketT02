package ca.ucalgary.farmersmarketapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class inventory_item_screen extends AppCompatActivity {

    ArrayList<inventory_item> inventoryItemList = new ArrayList<inventory_item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_item_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        generateRandomItems();

        ArrayList<String> stringList = new ArrayList<String>();

        for (int i = 0; i < inventoryItemList.size(); i++){
            stringList.add(inventoryItemList.get(i).getName());
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, stringList);

        ListView listView = (ListView) findViewById(R.id.inventoryList);
        listView.setAdapter(adapter);
    }

    public void generateRandomItems (){
        inventory_item anItem1 = new inventory_item("Apple");
        inventoryItemList.add(anItem1);
        inventory_item anItem2 = new inventory_item("Orange");
        inventoryItemList.add(anItem2);
        inventory_item anItem3 = new inventory_item("Pineapple");
        inventoryItemList.add(anItem3);
        inventory_item anItem4 = new inventory_item("Bread");
        inventoryItemList.add(anItem4);
        inventory_item anItem5 = new inventory_item("Brown Bread");
        inventoryItemList.add(anItem5);
        inventory_item anItem6 = new inventory_item("Cheese");
        inventoryItemList.add(anItem6);
        inventory_item anItem7 = new inventory_item("Milk");
        inventoryItemList.add(anItem7);
        inventory_item anItem8 = new inventory_item("Chocolate");
        inventoryItemList.add(anItem8);
        inventory_item anItem9 = new inventory_item("Almonds");
        inventoryItemList.add(anItem9);
        inventory_item anItem10 = new inventory_item("Banana");
        inventoryItemList.add(anItem10);
        inventory_item anItem11 = new inventory_item("Whip Cream");
        inventoryItemList.add(anItem11);
        inventory_item anItem12 = new inventory_item("Jam");
        inventoryItemList.add(anItem12);
        inventory_item anItem13 = new inventory_item("Salt");
        inventoryItemList.add(anItem13);
        inventory_item anItem14 = new inventory_item("Peper");
        inventoryItemList.add(anItem14);
        inventory_item anItem15 = new inventory_item("Lolipop");
        inventoryItemList.add(anItem15);
        inventory_item anItem16 = new inventory_item("Flour");
        inventoryItemList.add(anItem16);
        inventory_item anItem17 = new inventory_item("Bottled Water");
        inventoryItemList.add(anItem17);
    }

}
