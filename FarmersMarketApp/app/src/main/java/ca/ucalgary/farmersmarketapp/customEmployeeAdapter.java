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
 */

public class customEmployeeAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<employee> list;
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
        //text2.setMovementMethod(new ScrollingMovementMethod());
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
                final Button addManager = (Button)popupView.findViewById(R.id.addManagerButton);
                final Button removeManager = (Button)popupView.findViewById(R.id.removeManagerButton);
                final Button addCashier = (Button)popupView.findViewById(R.id.addCashierButton);
                final Button removeCashier = (Button)popupView.findViewById(R.id.removeCashierButton);
                final Button addInventoryCounter = (Button)popupView.findViewById(R.id.addInventoryCounterButton);
                final Button removeInventoryCounter = (Button)popupView.findViewById(R.id.removeInventoryCounterButton);
                final Button addCleaner = (Button)popupView.findViewById(R.id.addCleanerButton);
                final Button removeCleaner = (Button)popupView.findViewById(R.id.removeCleanerButton);

                Boolean addM = true;
                Boolean addC = true;
                Boolean addInv = true;
                Boolean addCln = true;

                //Check what roles the user has, and update booleans accordingly
                for (int i = 0; i < list.get(position).getRoles().size(); i++){
                    if (list.get(position).getRoles().get(i).equals("Manager")){
                        addM = false;
                    }
                    else if (list.get(position).getRoles().get(i).equals("Cashier")){
                        addC = false;
                    }
                    else if (list.get(position).getRoles().get(i).equals("Inventory")){
                        addInv = false;
                    }
                    else if (list.get(position).getRoles().get(i).equals("Cleaner")){
                        addCln = false;
                    }
                }

                //Set buttons according to If the role exists or not
                if (addM == false){
                    addManager.setEnabled(false);
                    addManager.getBackground().setAlpha(0);
                }
                else {
                    removeManager.setEnabled(false);
                    removeManager.getBackground().setAlpha(0);
                }

                if (addC == false){
                    addCashier.setEnabled(false);
                    addCashier.getBackground().setAlpha(0);
                }
                else {
                    removeCashier.setEnabled(false);
                    removeCashier.getBackground().setAlpha(0);
                }

                if (addInv == false){
                    addInventoryCounter.setEnabled(false);
                    addInventoryCounter.getBackground().setAlpha(0);
                }
                else {
                    removeInventoryCounter.setEnabled(false);
                    removeInventoryCounter.getBackground().setAlpha(0);
                }

                if (addCln == false){
                    addCleaner.setEnabled(false);
                    addCleaner.getBackground().setAlpha(0);
                }
                else {
                    removeCleaner.setEnabled(false);
                    removeCleaner.getBackground().setAlpha(0);
                }

                btnDismiss.setOnClickListener(new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        //Close popUpWindow
                        popupWindow.dismiss();
                        notifyDataSetChanged();
                    }});

                addManager.setOnClickListener(new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        list.get(position).addRole("Manager");
                        addManager.setEnabled(false);
                        addManager.getBackground().setAlpha(0);
                        removeManager.setEnabled(true);
                        removeManager.getBackground().setAlpha(255);
                    }});

                removeManager.setOnClickListener(new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        list.get(position).deleteRole("Manager");
                        addManager.setEnabled(true);
                        addManager.getBackground().setAlpha(255);
                        removeManager.setEnabled(false);
                        removeManager.getBackground().setAlpha(0);
                    }});

                addCashier.setOnClickListener(new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        list.get(position).addRole("Cashier");
                        addCashier.setEnabled(false);
                        addCashier.getBackground().setAlpha(0);
                        removeCashier.setEnabled(true);
                        removeCashier.getBackground().setAlpha(255);
                    }});

                removeCashier.setOnClickListener(new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        list.get(position).deleteRole("Cashier");
                        addCashier.setEnabled(true);
                        addCashier.getBackground().setAlpha(255);
                        removeCashier.setEnabled(false);
                        removeCashier.getBackground().setAlpha(0);
                    }});

                addInventoryCounter.setOnClickListener(new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        list.get(position).addRole("Inventory");
                        addInventoryCounter.setEnabled(false);
                        addInventoryCounter.getBackground().setAlpha(0);
                        removeInventoryCounter.setEnabled(true);
                        removeInventoryCounter.getBackground().setAlpha(255);
                    }});

                removeInventoryCounter.setOnClickListener(new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        list.get(position).deleteRole("Inventory");
                        addInventoryCounter.setEnabled(true);
                        addInventoryCounter.getBackground().setAlpha(255);
                        removeInventoryCounter.setEnabled(false);
                        removeInventoryCounter.getBackground().setAlpha(0);
                    }});

                addCleaner.setOnClickListener(new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        list.get(position).addRole("Cleaner");
                        addCleaner.setEnabled(false);
                        addCleaner.getBackground().setAlpha(0);
                        removeCleaner.setEnabled(true);
                        removeCleaner.getBackground().setAlpha(255);
                    }});

                removeCleaner.setOnClickListener(new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        list.get(position).deleteRole("Cleaner");
                        addCleaner.setEnabled(true);
                        addCleaner.getBackground().setAlpha(255);
                        removeCleaner.setEnabled(false);
                        removeCleaner.getBackground().setAlpha(0);
                    }});

                popupWindow.showAtLocation(editRoleButton, Gravity.CENTER, 0, 40);

            }});
   //         }
     //   });

        return view;
    }

    //UGLY but it keeps state, defiantly not oo.........
    public void updateEmployee(){

    }
}