package ca.ucalgary.farmersmarketapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Whoosp on 2016-11-14.
 */
public class Logs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeholder_screen);
    }

    public void backPressed(View view) {
        finish();
    }
}
