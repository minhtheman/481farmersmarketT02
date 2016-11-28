package ca.ucalgary.farmersmarketapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Whoosp on 2016-11-14.
 */
public class Sales extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_screen);
        EditText random = (EditText) findViewById(R.id.randomID);
        random.setFocusable(false);
    }

    public void backPressed(View view) {
        finish();
    }
}
