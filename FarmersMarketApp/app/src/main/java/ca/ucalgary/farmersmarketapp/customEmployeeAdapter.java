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

import static android.R.id.list;
import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by Whoosp on 2016-11-25.
 */

public class customEmployeeAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<employee> list = new ArrayList<employee>();
    private Context context;
    employees_screen employeesScreen;

    public customEmployeeAdapter (employees_screen employeesScreen, ArrayList<employee> list, Context context){
        this.list = list;
        this.context = context;
        this.employeesScreen = employeesScreen;
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
            view = inflater.inflate(R.layout.activity_employee_listview, null);
        }

        TextView text1 = (TextView) view.findViewById(R.id.text1);
        TextView text2 = (TextView) view.findViewById(R.id.text2);
        text1.setText(list.get(position).getFirstName() + " " + list.get(position).getLastName());

        String rolesList = "";
        boolean head = true;
        for (int i = 0; i < list.get(position).getRoles().size(); i++){
            if (head){
                rolesList = rolesList + " " + list.get(position).getRoles().get(i);
                head = false;
            }
            else{
                rolesList = rolesList + "," +  " " + list.get(position).getRoles().get(i);
            }
        }
        text2.setText(rolesList);

        //Handle buttons and add onClickListeners
        final Button editRoleButton = (Button)view.findViewById(R.id.editRoleButton);

        editRoleButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                //list.get(position).addRole("Person"); //Implement role adding or removing
                //notifyDataSetChanged();
                LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.activity_popup_add_roles, null);
                final PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);
                btnDismiss.setOnClickListener(new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        popupWindow.dismiss();
                    }});

                popupWindow.showAtLocation(editRoleButton, Gravity.CENTER, 0, 40);
                //popupWindow.showAsDropDown(editRoleButton, 50, -30);

            }});
   //         }
     //   });

        return view;
    }

    //UGLY but it keeps state, defiantly not oo.........
    public void updateEmployee(){

    }
}