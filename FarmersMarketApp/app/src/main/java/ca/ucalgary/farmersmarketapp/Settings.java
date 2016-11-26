package ca.ucalgary.farmersmarketapp;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * Created by Whoosp on 2016-11-14.
 */
public class Settings extends AppCompatActivity {

    PopupWindow popupWindow;
    LinearLayout popupLayout;
    LinearLayout.LayoutParams layoutParams;
    boolean isClicked = true;
    TextView popupMessage;
    Button popupWindowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        popupWindow = new PopupWindow(this);
        popupLayout = new LinearLayout(this);

        final Button popupButton = (Button)findViewById(R.id.popupButton);
        popupButton.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v){
                if (isClicked){
                    isClicked = false;
                    popupWindow.showAtLocation(R.layout.activity_placeholder_screen, Gravity.BOTTOM, 50, 50);
                    popupWindow.update(70, 70, 300, 100);
            }   else {
                    isClicked = true;
                    popupWindow.dismiss();
                }
            })
        });

        popupMessage = new TextView(this);
        popupMessage.setText("hello popup!");

        popupWindowButton = new Button(this);
        popupWindowButton.setText("Pop up window button");
        popupWindowButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                popupWindow.dismiss();
            }
        });

        layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popupLayout.setOrientation(LinearLayout.VERTICAL);
        popupLayout.addView(popupMessage, layoutParams);
        popupLayout.addView(popupWindowButton);
        setContentView(R.layout.activity_placeholder_screen);


    }

    public void backPressed(View view) {
        finish();
    }

}
