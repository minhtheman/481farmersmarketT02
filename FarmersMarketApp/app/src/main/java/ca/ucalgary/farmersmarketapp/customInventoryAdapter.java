package ca.ucalgary.farmersmarketapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Whoosp on 2016-11-25.
 */

public class customInventoryAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<inventory_item> list = new ArrayList<inventory_item>();
    private Context context;

    public customInventoryAdapter(ArrayList<inventory_item> list, Context context){
        this.list = list;
        this.context = context;
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

        Button temperatureButton = (Button)view.findViewById(R.id.tempAddButton);

        temperatureButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                list.get(position).addTempature(100);
                notifyDataSetChanged();
        }
        });


        return view;
    }
}