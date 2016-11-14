package com.example.whoosp.tutorial2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button theButton = (Button) findViewById(R.id.theButton);
        theButton.setOnClickListener(new View.OnClickListener() {
            boolean isToggled = true;

            public void onClick(View view) {
                Button theButton = (Button) findViewById(R.id.theButton);
                if (isToggled) {
                    theButton.setBackgroundColor(Color.RED);
                    isToggled = false;
                } else {
                    theButton.setBackgroundColor(Color.BLUE);
                    isToggled = true;
                }
            }
        });
    }

    public void hi_image(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setVisibility(View.VISIBLE);
    }

    public void bye_image (View view){
        ImageView im = (ImageView) findViewById(R.id.imageView);
        if (im.getVisibility() == View.VISIBLE){
            im.setVisibility(View.INVISIBLE);
        }
        else if (im.getVisibility() == View.INVISIBLE) {
            im.setVisibility(View.GONE);
        }
        else {
            im.setVisibility(View.VISIBLE);
        }
    }
}
