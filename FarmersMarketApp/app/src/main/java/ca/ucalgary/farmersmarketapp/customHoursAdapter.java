package ca.ucalgary.farmersmarketapp;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
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

import static android.R.id.list;
import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by Whoosp on 2016-11-25.
 * Copied from customEmployeeAdapter as dummy
 */

public class customHoursAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<employee> list;
    private Context context;


    public customHoursAdapter (ArrayList<employee> list, Context context){
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
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_hours_listview, null);
        }

        TextView text1 = (TextView) view.findViewById(R.id.text12);
        //text2.setMovementMethod(new ScrollingMovementMethod());
        text1.setText(list.get(position).getFirstName() + " " + list.get(position).getLastName());


        //Handle buttons and add onClickListeners
        final Button editRoleButton = (Button)view.findViewById(R.id.editRoleButton);

        editRoleButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //add functionality here

            }});
        //         }
        //   });

        return view;
    }

    //UGLY but it keeps state, defiantly not oo.........
    public void updateEmployee(){

    }
}