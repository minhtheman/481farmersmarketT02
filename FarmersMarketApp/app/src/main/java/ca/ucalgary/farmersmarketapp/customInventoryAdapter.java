package ca.ucalgary.farmersmarketapp;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by Whoosp on 2016-11-25.
 */

public class customInventoryAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<inventory_item> list = new ArrayList<inventory_item>();
    private Context context;
    private inventory_item_screen inventoryItemScreen;

    public customInventoryAdapter(inventory_item_screen inventoryItemScreen, ArrayList<inventory_item> list, Context context){
        this.list = list;
        this.context = context;
        this.inventoryItemScreen = inventoryItemScreen;
    }

    @Override
    public int getCount(){
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
        //jfor simplicity returning the position
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_inventory_listview, null);
        }
        TextView text1 = (TextView) view.findViewById(R.id.text1);
        text1.setText(list.get(position).getName());

        final Button temperatureButton = (Button)view.findViewById(R.id.tempAddButton);

        temperatureButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO
                //basically make a new layout called "activity_popup_temperature_log.xml"
                //have it so that we can add some text (numbers) and a submit button.
                //the submit button should close the window.
                //i can make the code to actually add the temperature log.
                //good luck!
                //(p.s. you may need to import some stuff and make variables, just do it like the customEmployeeAdapter.java)


                LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.activity_popup_temperature_log, null);
                final PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                Button btnDismiss = (Button)popupView.findViewById(R.id.tempDismiss);
                btnDismiss.setOnClickListener(new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }});

                popupWindow.showAtLocation(temperatureButton, Gravity.CENTER, 0, 40);
                //popupWindow.showAsDropDown(temperatureButton, 50, -30);

                //list.get(position).addTempature(100);
                //notifyDataSetChanged();
        }
        });

        return view;
    }
}