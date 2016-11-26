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

import static android.R.id.list;

/**
 * Created by Whoosp on 2016-11-25.
 */

public class customEmployeeAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<String> list = new ArrayList<String>();
    private ArrayList<String> list2 = new ArrayList<String>();
    private Context context;

    public customEmployeeAdapter (ArrayList<String> list, Context context){
        this.list = list;
        this.context = context;
    }

    public customEmployeeAdapter (ArrayList<String> list, ArrayList<String> list2, Context context){
        this.list = list;
        this.list2 = list2;
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
            view = inflater.inflate(R.layout.activity_employee_listview, null);
        }
        if (list2.size()>0){
            TextView text1 = (TextView) view.findViewById(R.id.text1);
            TextView text2 = (TextView) view.findViewById(R.id.text2);

            text1.setText(list.get(position));
            text2.setText(list2.get(position));
        }
        else{
            TextView text1 = (TextView) view.findViewById(R.id.text1);
            TextView text2 = (TextView) view.findViewById(R.id.text2);
            text1.setText(list.get(position));
        }

        //Handle buttons and add onClickListeners
        Button tempatureButton = (Button)view.findViewById(R.id.tempAddButton);

        tempatureButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                list.remove(position); //or some other task
                notifyDataSetChanged();
            }
        });


        return view;
    }
}